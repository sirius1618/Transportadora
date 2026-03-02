package com.github.sirius1618.transportadora_carros.servece;

import com.github.sirius1618.transportadora_carros.interfaces.SolicitarViagemAPI;
import com.github.sirius1618.transportadora_carros.model.SolicitacaoViagem;
import com.github.sirius1618.transportadora_carros.repository.SolicitacaoViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViagemService {

    @Autowired
    SolicitacaoViagemRepository solicitacaoViagemRepository;

    public SolicitacaoViagem saveSolicitarViagem(SolicitacaoViagem solicitacaoViagem) {
        return solicitacaoViagemRepository.save(solicitacaoViagem);
    }
}
