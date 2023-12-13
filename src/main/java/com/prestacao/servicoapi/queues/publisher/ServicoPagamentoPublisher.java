package com.prestacao.servicoapi.queues.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prestacao.servicoapi.dto.ServicoPagamentoDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ServicoPagamentoPublisher {

    private final AmqpTemplate directExchange;

    @Value("${rabbitmq.direct.routing-key-servico-pagamentos")
    private String ROUTING_KEY_SERVICO_PAGAMENTOS;

    public void enviarSolicitar(ServicoPagamentoDto servicoPagamentoDto)
            throws JsonProcessingException {
        log.info("Enviando a solicitação de pagamento para fila...");

        directExchange.convertAndSend(ROUTING_KEY_SERVICO_PAGAMENTOS, servicoPagamentoDto);

        log.info("Fim do envio da solicitação.");

    }

}
