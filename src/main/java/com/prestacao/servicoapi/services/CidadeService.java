package com.prestacao.servicoapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prestacao.servicoapi.exceptions.CidadeNotFoundException;
import com.prestacao.servicoapi.models.Cidade;
import com.prestacao.servicoapi.models.Provincia;
import com.prestacao.servicoapi.repositories.CidadeRepository;

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
