package com.prestacao.servicoapi.services;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.prestacao.servicoapi.bulders.CidadeBuilder;
import com.prestacao.servicoapi.bulders.ClienteBuilder;
import com.prestacao.servicoapi.dto.CidadeDto;
import com.prestacao.servicoapi.dto.ClienteDto;
import com.prestacao.servicoapi.dto.EnderecoDto;
import com.prestacao.servicoapi.dto.UsuarioResponseDto;
import com.prestacao.servicoapi.models.Cidade;
import com.prestacao.servicoapi.models.Cliente;
import com.prestacao.servicoapi.models.Endereco;
import com.prestacao.servicoapi.models.Usuario;
import com.prestacao.servicoapi.repositories.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final UsuarioService usuarioService;
    private final EnderecoService enderecoService;
    private final ClienteBuilder clienteBuilder;

    @Transactional
    public ClienteDto salvar(ClienteDto clienteDto) {
        clienteDto.setDataCadastro(LocalDateTime.now());

        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDto, cliente);

        CidadeDto cidadeDto = CidadeDto
                .builder()
                .id(clienteDto.getEndereco().getCidade().getId())
                .provincia(clienteDto.getEndereco().getCidade().getProvincia())
                .build();

        EnderecoDto enderecodDto = EnderecoDto
                .builder()
                .descricao(clienteDto.getEndereco().getDescricao())
                .cidade(cidadeDto)
                .build();

        Endereco endereco = enderecoService.salvar(enderecodDto);
        cliente.setEndereco(endereco);

        Usuario usuario = usuarioService.findById(clienteDto.getUsuario().getId());
        cliente.setUsuario(usuario);

        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();
        BeanUtils.copyProperties(usuario, usuarioResponseDto);

        Cliente clienteSalvo = clienteRepository.save(cliente);
        // clienteDto.setId(clienteSalvo.getId());
        // clienteDto.setEndereco(enderecodDto);
        // clienteDto.setUsuario(usuarioResponseDto);

        return clienteBuilder.toDto(clienteSalvo);

    }
}
