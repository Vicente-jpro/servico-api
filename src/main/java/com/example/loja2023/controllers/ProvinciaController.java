package com.example.loja2023.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.loja2023.models.Provincia;
import com.example.loja2023.repositories.ProvinciaRepository;
import com.example.loja2023.services.ProvinciaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/provincias")
@RequiredArgsConstructor
public class ProvinciaController {
    private final ProvinciaService provinciaService;

    @GetMapping("/{id}")
    @ApiOperation("Buscar provincia pelo ID")
    @ApiResponse(code = 200, message = "Provincia buscada com sucesso.")
    public ResponseEntity<Provincia> getProvinciaById(@PathVariable("id") Long idProvincia) {
        log.info("Buscando provincia pelo ID: {}", idProvincia);
        return ResponseEntity.ok(provinciaService.getProvinciaById(idProvincia));
    }

    @GetMapping
    @ApiOperation("Buscar todas as provincia.")
    @ApiResponse(code = 200, message = "Provincias buscada com sucesso.")
    public ResponseEntity<List<Provincia>> getListaProvincias() {
        log.info("Buscando todas as provincias...");
        return ResponseEntity.ok(provinciaService.getListaProvincias());
    }

}
