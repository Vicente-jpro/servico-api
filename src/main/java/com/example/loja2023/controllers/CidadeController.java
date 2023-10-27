package com.example.loja2023.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loja2023.models.Cidade;
import com.example.loja2023.services.CidadeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cidades")
@RequiredArgsConstructor
public class CidadeController {

    private final CidadeService cidadeService;

    @GetMapping("/{id_provincia}")
    @ApiOperation("Listar cidades pelo id_provincia.")
    @ApiResponse(code = 200, message = "Cidade listada com sucesso.")
    public ResponseEntity<List<Cidade>> getCidadesByIdProvincia(@PathVariable("id") Long idprovincia) {
        return ResponseEntity.ok(cidadeService.getCidadesByIdProvincia(idprovincia));
    }

    @GetMapping
    @ApiOperation("Listar cidades.")
    @ApiResponse(code = 200, message = "Cidade listada com sucesso.")
    public ResponseEntity<Cidade> getCidadeById(@PathVariable("id") Long idCidade) {
        return ResponseEntity.ok(cidadeService.getCidadeById(idCidade));
    }
}
