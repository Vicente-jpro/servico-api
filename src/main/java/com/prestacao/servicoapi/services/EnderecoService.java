package com.prestacao.servicoapi.services;

import org.springframework.stereotype.Service;

import com.prestacao.servicoapi.dto.EnderecoDto;
import com.prestacao.servicoapi.exceptions.EnderecoNotFoundException;
import com.prestacao.servicoapi.models.Cidade;
import com.prestacao.servicoapi.models.Endereco;
import com.prestacao.servicoapi.repositories.EnderecoRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class EnderecoService {

    private final CidadeService cidadeService;
    private final EnderecoRepository enderecoRepository;

    public Endereco salvar(EnderecoDto enderecoDto) {
        log.info("Salvar endereço...");

        Long idCidade = enderecoDto.getCidade().getId();

        Cidade cidade = cidadeService.getCidadeById(idCidade);
        Endereco endereco = new Endereco();
        endereco.setId(enderecoDto.getId());
        endereco.setCidade(cidade);
        endereco.setDescricao(enderecoDto.getDescricao());

        endereco = enderecoRepository.save(endereco);
        log.info("Fim da operação salvar endereço.");

        return endereco;
    }

    public Endereco getEnderecoById(Long idEndereco) {
        log.info("Buscar endereço com ID: {}", idEndereco);

        return enderecoRepository.findById(idEndereco)
                .orElseThrow(() -> new EnderecoNotFoundException("Endereço não encontrado ID: " + idEndereco));
    }

    public Endereco atualizar(EnderecoDto enderecoDto, Long idEndereco) {
        log.info("Atualizar endereço...");

        Endereco endereco = getEnderecoById(idEndereco);

        if (endereco == null) {
            log.info("Endereco não encontrado");
            throw new EnderecoNotFoundException("Endereço não encrontrado");
        }

        enderecoDto.setId(idEndereco);
        return salvar(enderecoDto);
    }

}
