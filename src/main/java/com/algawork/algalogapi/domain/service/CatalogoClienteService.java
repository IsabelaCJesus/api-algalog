package com.algawork.algalogapi.domain.service;

import com.algawork.algalogapi.domain.exception.NegocioException;
import com.algawork.algalogapi.domain.model.Cliente;
import com.algawork.algalogapi.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CatalogoClienteService {

    private ClienteRepository clienteRepository;

    public Cliente buscar(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new NegocioException(("Cliente nao encontrado")));
    }

    @Transactional
    public Cliente salvar(Cliente cliente){
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail()).stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

        if(emailEmUso){
            throw  new NegocioException("Ja existe cliente cadastrado com esse e-mail.");
        }
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long id){
        clienteRepository.deleteById(id);
    }
}
