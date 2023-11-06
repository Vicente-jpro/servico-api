package com.prestacao.servicoapi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prestacao.servicoapi.models.Cidade;
import com.prestacao.servicoapi.services.CidadeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cidades")
@RequiredArgsConstructor
public class CidadeController {

    private final CidadeService cidadeService;

    @GetMapping("/{id_provincia}/provincia")
    @ApiOperation("Listar cidades pelo id_provincia.")
    @ApiResponse(code = 200, message = "Cidade listada com sucesso.")
    public ResponseEntity<List<Cidade>> getCidadesByIdProvincia(@PathVariable("id_provincia") Long idprovincia) {
        return ResponseEntity.ok(cidadeService.getCidadesByIdProvincia(idprovincia));
    }

    @GetMapping
    @ApiOperation("Listar cidades.")
    @ApiResponse(code = 200, message = "Cidade listada com sucesso.")
    public ResponseEntity<Cidade> getCidadeById(@PathVariable("id") Long idCidade) {
        return ResponseEntity.ok(cidadeService.getCidadeById(idCidade));
    }
}
