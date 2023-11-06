package com.prestacao.servicoapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prestacao.servicoapi.models.Usuario;
import com.prestacao.servicoapi.services.UsuarioService;

import java.util.List;

import javax.validation.Valid;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @ApiOperation("Salvar usuário.")
    @ApiResponse(code = 200, message = "Usuario criado novo usuário")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody @Valid Usuario usuario) {
        return this.usuarioService.save(usuario);
    }

    @GetMapping
    @ApiOperation("Listar todos usuarios.")
    @ApiResponse(code = 302, message = "Usuários encontrados.")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Usuario> listarTodos() {
        return this.usuarioService.listarTodos();
    }
}
