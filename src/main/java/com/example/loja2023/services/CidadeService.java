package com.example.loja2023.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.loja2023.exceptions.CidadeNotFoundException;
import com.example.loja2023.models.Cidade;
import com.example.loja2023.models.Provincia;
import com.example.loja2023.repositories.CidadeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CidadeService {

    private final CidadeRepository cidadeRepository;

    public List<Cidade> getCidadesByIdProvincia(Long idProvincia) {
        log.info("Buscar cidades pela provincia id_provincia: {}", idProvincia);
        Provincia provincia = new Provincia();
        provincia.setId(idProvincia);

        return cidadeRepository.findAllByProvincia(provincia);
    }

    public Cidade getCidadeById(Long idCidade) {
        log.info("Buscar cidade pelo ID: {}", idCidade);
        return cidadeRepository.findById(idCidade)
                .orElseThrow(() -> new CidadeNotFoundException("Cidade não encontrada ID: " + idCidade));
    }

}
