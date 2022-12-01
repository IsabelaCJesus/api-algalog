package com.algawork.algalogapi.domain.service;

import com.algawork.algalogapi.domain.exception.EntidadeNaoEncontradaException;
import com.algawork.algalogapi.domain.exception.NegocioException;
import com.algawork.algalogapi.domain.model.Entrega;
import com.algawork.algalogapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    private EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId){
        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega nao encontrada"));
    }
}
