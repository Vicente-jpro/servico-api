package com.example.loja2023.services;

import org.springframework.stereotype.Service;

import com.example.loja2023.dto.EnderecoDto;
import com.example.loja2023.exceptions.EnderecoNotFoundException;
import com.example.loja2023.models.Cidade;
import com.example.loja2023.models.Endereco;
import com.example.loja2023.repositories.EnderecoRepository;

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
        Endereco endereco = Endereco
                .builder()
                .cidade(cidade)
                .descricao(enderecoDto.getDescricao())
                .build();

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
