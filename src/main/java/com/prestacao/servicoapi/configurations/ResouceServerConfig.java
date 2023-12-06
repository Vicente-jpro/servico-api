package com.prestacao.servicoapi.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResouceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/clientes/**").authenticated()
                .antMatchers("/enderecos/**").authenticated()
                .antMatchers("/usuarios/**").permitAll()
                .antMatchers("/provincias/**").permitAll()
                .antMatchers("/cidades/**").permitAll()
                .antMatchers("/tipo-servicos/**").permitAll()
                .antMatchers("/servico-prestados/**").permitAll()
                .anyRequest().denyAll();

    }

}
