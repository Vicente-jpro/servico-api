package com.prestacao.servicoapi.configurations;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class RabbitConnetion {

    @Value("${spring.rabbitmq.host}")
    private String HOST;

    @Value("${spring.rabbitmq.port}")
    private Integer PORT;

    @Value("${spring.rabbitmq.username}")
    private String USERNAME;

    @Value("${spring.rabbitmq.password}")
    private String PASSWORD;

    private String VIRTUAL_HOST = "/";

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUsername(USERNAME);
        connectionFactory.setPassword(PASSWORD);
        connectionFactory.setPort(PORT);
        connectionFactory.setHost(HOST);
        connectionFactory.setVirtualHost(VIRTUAL_HOST);
        return connectionFactory;
    }

    @Bean
    public MessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean
    public SimpleRabbitListenerContainerFactory listenerContainerFactory() {
        SimpleRabbitListenerContainerFactory listenerContainerFactory = new SimpleRabbitListenerContainerFactory();

        listenerContainerFactory.setConnectionFactory(connectionFactory());
        listenerContainerFactory.setMessageConverter(messageConverter());
        // Max number of consumer
        listenerContainerFactory.setMaxConcurrentConsumers(10);
        // Max concurrent consumer
        listenerContainerFactory.setConcurrentConsumers(5);
        // Listen the aplication initialization
        listenerContainerFactory.setAutoStartup(true);
        // How many messages going to be sent to the consumer at the same time
        listenerContainerFactory.setPrefetchCount(10);

        return listenerContainerFactory;
    }

}
