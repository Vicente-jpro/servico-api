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
    private final ProvinciaService provinciaService;

    public List<Cidade> getCidadesByProvincia(Provincia provincia) {
        log.info("Buscar cidades pela provincia id_provincia: {}", provincia.getId());
        Provincia prov = provinciaService.getProvinciaById(provincia.getId());

        return cidadeRepository.findAllByProvincia(prov);

    }

    public Cidade getCidadeById(Long idCidade) {
        log.info("Buscar cidade pelo ID: {}", idCidade);
        return cidadeRepository.findById(idCidade)
                .orElseThrow(() -> new CidadeNotFoundException("Cidade não encontrada ID: " + idCidade));
    }

}
