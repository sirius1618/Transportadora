package com.github.sirius1618.transportadora_carros.interfaces.mapper;

import com.github.sirius1618.transportadora_carros.interfaces.dto.input.SolicitarViagemInput;
import com.github.sirius1618.transportadora_carros.model.Passageiro;
import com.github.sirius1618.transportadora_carros.model.SolicitacaoViagem;
import com.github.sirius1618.transportadora_carros.repository.PassageiroRepository;
import com.github.sirius1618.transportadora_carros.repository.SolicitacaoViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SolicitarViagemMapper {

    @Autowired
    PassageiroRepository passageiroRepository;

    public SolicitacaoViagem map (SolicitarViagemInput input) {

        Passageiro passageiro = passageiroRepository.findById(input.passageiroId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        SolicitacaoViagem solicitacaoViagem = new SolicitacaoViagem();
        solicitacaoViagem.setPassageiro(passageiro);
        solicitacaoViagem.setOrigem(input.destino());
        solicitacaoViagem.setOrigem(input.origem());

        return solicitacaoViagem;
    }
}
