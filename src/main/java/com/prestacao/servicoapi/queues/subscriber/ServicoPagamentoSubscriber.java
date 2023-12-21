package com.prestacao.servicoapi.queues.subscriber;

import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.prestacao.servicoapi.builders.ServicoPagamentoBuilder;
import com.prestacao.servicoapi.builders.ServicoPrestadoBuilder;
import com.prestacao.servicoapi.dto.ServicoPagamentoDto;
import com.prestacao.servicoapi.dto.ServicoPrestadoDto;
import com.prestacao.servicoapi.models.ServicoPagamento;
import com.prestacao.servicoapi.models.ServicoPrestado;
import com.prestacao.servicoapi.repositories.ServicoPagamentoRepository;
import com.prestacao.servicoapi.services.ServicoPrestadoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ServicoPagamentoSubscriber {

    private final ServicoPagamentoRepository servicoPagamentoRepository;
    private final ServicoPagamentoBuilder servicoPagamentoBuilder;
    private final ServicoPrestadoService servicoPrestadoService;
    private final ServicoPrestadoBuilder servicoPrestadoBuilder;

    @RabbitListener(queues = { "${rabbitmq.queues.servico-pagamentos}" }, containerFactory = "listenerContainerFactory")
    public void receberSolicitacaoPagamento(@Payload ServicoPagamentoDto servicoPagamentoDto) {

        try {

            log.info("Solcitar cartão.");

            ServicoPrestadoDto servicoPrestadoDto = servicoPrestadoService
                    .getServicoPrestadoById(servicoPagamentoDto.getServicoPrestado().getId());

            ServicoPrestado servicoPrestado = servicoPrestadoBuilder.toModel(servicoPrestadoDto);

            ServicoPagamento servicoPagamento = ServicoPagamento.builder()
                    .id(servicoPagamentoDto.getId())
                    .valorPago(servicoPagamentoDto.getValorPago())
                    .servicoPrestado(servicoPrestado)
                    .formaPagamento(servicoPagamentoDto.getFormaPagamento())
                    .build();

            if (servicoPagamentoDto.getId() == null) {
                servicoPagamento.setDataPagamento(LocalDateTime.now());
            }

            ServicoPagamento serPagamentoSalvo = servicoPagamentoRepository.save(servicoPagamento);
            ServicoPagamentoDto servicoPagamentoSalvoDto = servicoPagamentoBuilder.toDto(serPagamentoSalvo);

        } catch (Exception e) {
            log.error("Não foi possivel ler o Servico Pagemento na fila.");
        }

    }
}
