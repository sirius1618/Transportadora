package com.github.sirius1618.transportadora_carros.interfaces.dto.input;

import com.github.sirius1618.transportadora_carros.model.Passageiro;

public record SolicitarViagemInput(
        Long   passageiroId,
        String origem,
        String destino
) { }
