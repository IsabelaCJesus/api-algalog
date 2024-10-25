package com.algawork.algalogapi.domain.service;

import com.algawork.algalogapi.domain.exception.NegocioException;
import com.algawork.algalogapi.domain.model.Entrega;
import com.algawork.algalogapi.domain.model.StatusEntrega;
import com.algawork.algalogapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

    private EntregaRepository entregaRepository;
    private BuscaEntregaService buscaEntregaService;

    @Transactional
    public void finalizar(Long entregaId){
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        entrega.finalizar();

        entregaRepository.save(entrega);
    }
}
