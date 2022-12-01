package com.algawork.algalogapi.api.controller;

import com.algawork.algalogapi.api.assembler.OcorrenciaAssembler;
import com.algawork.algalogapi.api.model.OcorrenciaModel;
import com.algawork.algalogapi.api.model.input.OcorrenciaInput;
import com.algawork.algalogapi.domain.model.Entrega;
import com.algawork.algalogapi.domain.model.Ocorrencia;
import com.algawork.algalogapi.domain.service.BuscaEntregaService;
import com.algawork.algalogapi.domain.service.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    private BuscaEntregaService buscaEntregaService;
    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaAssembler ocorrenciaAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaModel registrar(@PathVariable Long entregaId, @RequestBody @Valid OcorrenciaInput ocorrenciaInput){
        Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService
                .registrar(entregaId, ocorrenciaInput.getDescricao());

        return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
    }

    @GetMapping
    public List<OcorrenciaModel> listar(@PathVariable Long entregaId){
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
    }
}
