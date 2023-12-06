package com.prestacao.servicoapi.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.prestacao.servicoapi.bulders.ServicoPrestadoBuilder;
import com.prestacao.servicoapi.bulders.TipoServicoBuilder;
import com.prestacao.servicoapi.dto.ClienteDto;
import com.prestacao.servicoapi.dto.ServicoPrestadoDto;
import com.prestacao.servicoapi.exceptions.ServicoPrestadoNotFoundException;
import com.prestacao.servicoapi.models.ServicoPrestado;
import com.prestacao.servicoapi.models.TipoServico;
import com.prestacao.servicoapi.repositories.ServicoPrestadoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServicoPrestadoService {

    private final ServicoPrestadoRepository servicoPrestadoRepository;
    private final TipoServicoService tipoServicoService;
    private final TipoServicoBuilder tipoServicoBuilder;
    private final ClienteService clienteService;
    private final ServicoPrestadoBuilder servicoPrestadoBuilder;

    public ServicoPrestadoDto salvar(ServicoPrestadoDto servicoPrestadoDto) {
        log.info("Salvando o Servico prestado...");
        TipoServico tipoServico = tipoServicoService.getTipoServicoById(servicoPrestadoDto.getTipoServico().getId());
        ClienteDto clienteDto = clienteService.getClienteById(servicoPrestadoDto.getCliente().getId());
        if (clienteDto == null) {
            log.warn("Cliente não existe.");
            clienteDto = clienteService.salvar(clienteDto);
        } else if (servicoPrestadoDto.getId() == null) {
            servicoPrestadoDto.setDataCadastro(LocalDateTime.now());
        }

        servicoPrestadoDto.setCliente(clienteDto);
        servicoPrestadoDto.setTipoServico(tipoServicoBuilder.toDto(tipoServico));
        ServicoPrestado servicoPrestado = servicoPrestadoBuilder.toModel(servicoPrestadoDto);

        LocalDate dataInicio = LocalDate.parse(servicoPrestadoDto.getDataInicio(),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        LocalDate dataFim = LocalDate.parse(servicoPrestadoDto.getDataFim(),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        servicoPrestado.setDataInicio(dataInicio);
        servicoPrestado.setDataFim(dataFim);

        ServicoPrestado servicoSalvo = servicoPrestadoRepository.save(servicoPrestado);
        log.info("Servico Prestado salvo com sucesso");

        return servicoPrestadoBuilder.toDto(servicoSalvo);
    }

    public ServicoPrestadoDto getServicoPrestadoById(Long idServicoPrestado) {
        log.info("Buscando o Servico Prestado pelo ID: {}", idServicoPrestado);
        ServicoPrestado servicoPrestado = servicoPrestadoRepository
                .findById(idServicoPrestado)
                .orElseThrow(
                        () -> new ServicoPrestadoNotFoundException("Servico Prestado não exite: " + idServicoPrestado));

        return servicoPrestadoBuilder.toDto(servicoPrestado);

    }

    public ServicoPrestadoDto atualizar(ServicoPrestadoDto servicoPrestadoDto, Long idServicoPrestado) {
        log.info("Atualizando o Servico Prestado: {}", idServicoPrestado);
        ServicoPrestadoDto servicoPrestado = getServicoPrestadoById(idServicoPrestado);
        servicoPrestadoDto.setId(servicoPrestado.getId());

        return salvar(servicoPrestadoDto);
    }

    public void eliminar(Long idServicoPrestado) {
        servicoPrestadoRepository.deleteById(idServicoPrestado);
    }
}
