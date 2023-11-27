package com.prestacao.servicoapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prestacao.servicoapi.models.TipoServico;
import com.prestacao.servicoapi.services.TipoServicoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/tipo-servicos")
@RequiredArgsConstructor
public class TipoServicoController {
    private final TipoServicoService tipoServicoService;

    @PostMapping
    @ApiOperation("Salvar Tipo de Serviços.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Tipo de servico encontrado."),
            @ApiResponse(code = 404, message = "Tipo de Servico não foi encontrado.")
    })
    @ResponseStatus(HttpStatus.CREATED)
    public TipoServico salvar(@RequestBody TipoServico tipoServico) {
        log.info("Salvar Tipo de Serviço.");
        return tipoServicoService.salvar(tipoServico);
    }

    @PatchMapping("{/id}")
    @ApiOperation("Atualizar um Tipo de Serviço.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Tipo de Serviço atualizado com sucesso."),
            @ApiResponse(code = 404, message = "Tipo de serviço não encontrado.")
    })
    @ResponseStatus(HttpStatus.OK)
    public TipoServico atualizar(@RequestBody TipoServico tipoServico,
            @PathVariable("id") Long idCliente) {
        log.info("Atualizar Tipo de Servico.");
        return tipoServicoService.atualizar(tipoServico, idCliente);
    }

    @DeleteMapping("{/id}")
    @ApiOperation("Eliminar um Tipo de Serviço.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Tipo de Serviço eliminado com sucesso."),
            @ApiResponse(code = 404, message = "Tipo de serviço não encontrado.")
    })
    @ResponseStatus(HttpStatus.OK)
    public void eliminar(@PathVariable("id") Long idTipoServico) {
        log.info("Eliminar Tipo de Servico.");
        tipoServicoService.eliminar(idTipoServico);
    }

    @GetMapping("{/id}")
    @ApiOperation("Buscar um Tipo de Serviço.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Tipo de Serviço encontrado com sucesso."),
            @ApiResponse(code = 404, message = "Tipo de serviço não encontrado.")
    })
    @ResponseStatus(HttpStatus.OK)
    public TipoServico getServicoById(@PathVariable("id") Long idTipoServico) {
        log.info("Eliminar Tipo de Servico.");
        return tipoServicoService.getTipoServico(idTipoServico);
    }
}
