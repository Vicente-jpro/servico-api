package com.prestacao.servicoapi.services;

import java.time.LocalDateTime;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.prestacao.servicoapi.bulders.ServicoPagamentoBuilder;
import com.prestacao.servicoapi.bulders.ServicoPrestadoBuilder;
import com.prestacao.servicoapi.dto.ServicoPagamentoDto;
import com.prestacao.servicoapi.dto.ServicoPrestadoDto;
import com.prestacao.servicoapi.models.ServicoPagamento;
import com.prestacao.servicoapi.models.ServicoPrestado;
import com.prestacao.servicoapi.repositories.ServicoPagamentoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServicoPagamentoService {

    private final ServicoPagamentoRepository servicoPagamentoRepository;
    private final ServicoPagamentoBuilder servicoPagamentoBuilder;
    private final ServicoPrestadoService servicoPrestadoService;
    private final ServicoPrestadoBuilder servicoPrestadoBuilder;

    private final AmqpTemplate directExchange;

    @Value("${rabbitmq.direct.routing-key-servico-pagamentos")
    private String ROUTING_KEY_SERVICO_PAGAMENTOS;

    public ServicoPagamentoDto salvar(ServicoPagamentoDto servicoPagamentoDto) {
        log.info("Salvando o Servico Pagamento...");
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

        directExchange.convertAndSend(ROUTING_KEY_SERVICO_PAGAMENTOS, servicoPagamentoSalvoDto);
        log.info("Salvando o Servico Pagamento salvo com sucesso.");
        return servicoPagamentoSalvoDto;
    }

}
