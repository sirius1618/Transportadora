package com.github.sirius1618.transportadora_carros.interfaces;

import com.github.sirius1618.transportadora_carros.interfaces.dto.input.SolicitarViagemInput;
import com.github.sirius1618.transportadora_carros.interfaces.mapper.SolicitarViagemMapper;
import com.github.sirius1618.transportadora_carros.model.SolicitacaoViagem;
import com.github.sirius1618.transportadora_carros.servece.ViagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@Service
@RestController
@RequestMapping(path = "solicitarViagem", produces = MediaType.APPLICATION_JSON_VALUE)

public class SolicitarViagemAPI {

    @Autowired
    ViagemService viagemService;

    @Autowired
    SolicitarViagemMapper mapper;

    @PostMapping()
    public void solicitarViagem(@RequestBody SolicitarViagemInput solicitarViagemInput) {
        viagemService.saveSolicitarViagem(mapper.map(solicitarViagemInput));
    }
}
