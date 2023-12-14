package com.prestacao.servicoapi.services;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.prestacao.servicoapi.dto.ServicoPagamentoDto;
import com.prestacao.servicoapi.queues.publisher.ServicoPagamentoPublisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServicoPagamentoService {

    private final ServicoPagamentoPublisher servicoPagamentoPublisher;

    public void salvar(ServicoPagamentoDto servicoPagamentoDto)
            throws JsonProcessingException {
        log.info("Salvando o Servico Pagamento...");

        servicoPagamentoPublisher.enviarSolicitar(servicoPagamentoDto);

        log.info("Salvando o Servico Pagamento salvo com sucesso.");
        // return servicoPagamentoSalvoDto;
    }

}
