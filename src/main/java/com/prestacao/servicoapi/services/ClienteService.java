package com.prestacao.servicoapi.services;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.prestacao.servicoapi.bulders.ClienteBuilder;
import com.prestacao.servicoapi.dto.CidadeDto;
import com.prestacao.servicoapi.dto.ClienteDto;
import com.prestacao.servicoapi.dto.EnderecoDto;
import com.prestacao.servicoapi.dto.UsuarioResponseDto;
import com.prestacao.servicoapi.exceptions.ClienteNotFoundException;
import com.prestacao.servicoapi.models.Cliente;
import com.prestacao.servicoapi.models.Endereco;
import com.prestacao.servicoapi.models.Usuario;
import com.prestacao.servicoapi.repositories.ClienteRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final UsuarioService usuarioService;
    private final EnderecoService enderecoService;
    private final ClienteBuilder clienteBuilder;

    @Transactional
    public ClienteDto salvar(ClienteDto clienteDto) {
        log.info("Salvando cliente...");
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
                .id(clienteDto.getEndereco().getId())
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
        log.info("Cliente salvo com sucesso");

        return clienteBuilder.toDto(clienteSalvo);

    }

    public ClienteDto atualizar(ClienteDto clienteDto, Long idCliente) {
        log.info("Atualizando o cliente...");
        ClienteDto cliente = getClienteById(idCliente);
        if (cliente != null) {
            clienteDto.setId(cliente.getId());
            clienteDto.getEndereco().setId(cliente.getEndereco().getId());

        }
        return salvar(clienteDto);
    }

    public ClienteDto getClienteById(Long idCliente) {
        log.info("Buscando cliente pelo ID: " + idCliente);
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado ID: " + idCliente));

        return clienteBuilder.toDto(cliente);
    }

    public void eliminar(Long idCliente) {
        log.info("Eliminando cliente...");
        ClienteDto clienteDto = getClienteById(idCliente);
        clienteRepository.deleteById(clienteDto.getId());
    }
}
