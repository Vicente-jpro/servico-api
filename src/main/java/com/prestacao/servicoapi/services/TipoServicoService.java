package com.prestacao.servicoapi.services;

import org.springframework.stereotype.Service;

import com.prestacao.servicoapi.exceptions.TipoServicoFoundException;
import com.prestacao.servicoapi.models.TipoServico;
import com.prestacao.servicoapi.repositories.TipoServicoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TipoServicoService {

    private TipoServicoRepository tipoServicoRepository;

    public TipoServico salvar(TipoServico tipoServico) {
        log.info("Salvando o tipo de serviço");
        return tipoServicoRepository.save(tipoServico);
    }

    public TipoServico getTipoServico(Long idTipoServico) {
        log.info("Buscando o tipo de servico pelo ID: " + idTipoServico);
        return tipoServicoRepository.findById(idTipoServico)
                .orElseThrow(() -> new TipoServicoFoundException("Tipo de servico não encontrado ID:" + idTipoServico));
    }

    public void eliminar(Long idTipoServico) {
        log.info("Eliminando o tipo de servico pelo ID: " + idTipoServico);
        TipoServico tipoServico = getTipoServico(idTipoServico);
        tipoServicoRepository.deleteById(tipoServico.getId());
    }

    public TipoServico atualizar(TipoServico tipoServico, Long idTipoServico) {
        log.info("Atualizando o tipo de servico pelo ID: " + idTipoServico);
        TipoServico servico = getTipoServico(idTipoServico);
        tipoServico.setId(servico.getId());
        return salvar(tipoServico);
    }

}
