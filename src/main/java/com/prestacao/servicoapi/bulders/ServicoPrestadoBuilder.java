package com.prestacao.servicoapi.bulders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.prestacao.servicoapi.dto.ServicoPrestadoDto;
import com.prestacao.servicoapi.models.ServicoPrestado;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ServicoPrestadoBuilder {

        private final TipoServicoBuilder tipoServicoBuilder;
        private final ClienteBuilder clienteBuilder;

        public ServicoPrestado toModel(ServicoPrestadoDto servicoPrestadoDto) {
                LocalDate dataInicio = LocalDate.parse(servicoPrestadoDto.getDataInicio());
                LocalDate dataFim = LocalDate.parse(servicoPrestadoDto.getDataFim());

                return new ServicoPrestado(
                                servicoPrestadoDto.getId(),
                                dataInicio,
                                dataFim,
                                servicoPrestadoDto.getDataCadastro(),
                                servicoPrestadoDto.getPagamentoParcela(),
                                tipoServicoBuilder.toModel(servicoPrestadoDto.getTipoServico()),
                                clienteBuilder.toModel(servicoPrestadoDto.getCliente()));
        }

        public ServicoPrestadoDto toDto(ServicoPrestado servicoPrestado) {

                return ServicoPrestadoDto.builder()
                                .id(servicoPrestado.getId())
                                .dataCadastro(servicoPrestado.getDataCadastro())
                                .dataInicio(servicoPrestado.getDataInicio().toString())
                                .dataFim(servicoPrestado.getDataFim().toString())
                                .dataCadastro(servicoPrestado.getDataCadastro())
                                .pagamentoParcela(servicoPrestado.getPagamentoParcela())
                                .tipoServico(tipoServicoBuilder.toDto(servicoPrestado.getTipoServico()))
                                .cliente(clienteBuilder.toDto(servicoPrestado.getCliente()))
                                .build();
        }
}
