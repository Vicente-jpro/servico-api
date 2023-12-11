package com.prestacao.servicoapi.bulders;

import org.springframework.stereotype.Component;

import com.prestacao.servicoapi.dto.ClienteDto;
import com.prestacao.servicoapi.models.Cliente;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClienteBuilder {

    private final EnderecoBuilder enderecoBuilder;
    private final UsuarioBuilder usuarioBuilder;

    public Cliente toModel(ClienteDto clienteDto) {
        return Cliente
                .builder()
                .id(clienteDto.getId())
                .nome(clienteDto.getNome())
                .telemovel1(clienteDto.getTelemovel1())
                .telemovel2(clienteDto.getTelemovel2())
                .genero(clienteDto.getGenero())
                .endereco(enderecoBuilder.toModel(clienteDto.getEndereco()))
                .usuario(usuarioBuilder.toModel(clienteDto.getUsuario()))
                .dataCadastro(clienteDto.getDataCadastro())
                .build();
    }

    public ClienteDto toDto(Cliente cliente) {
        return ClienteDto
                .builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .telemovel1(cliente.getTelemovel1())
                .telemovel2(cliente.getTelemovel2())
                .genero(cliente.getGenero())
                .endereco(enderecoBuilder.toDto(cliente.getEndereco()))
                .usuario(usuarioBuilder.toResponseDto(cliente.getUsuario()))
                .dataCadastro(cliente.getDataCadastro())
                .build();

    }
}
