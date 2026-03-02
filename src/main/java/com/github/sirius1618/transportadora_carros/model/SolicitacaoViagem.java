package com.github.sirius1618.transportadora_carros.model;

import com.github.sirius1618.transportadora_carros.domain.SolicitacaoViagemStatus;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class SolicitacaoViagem {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @ManyToOne
     private Passageiro passageiro;
     private String origem;
     private String destino;

     @Enumerated(EnumType.STRING)
     private SolicitacaoViagemStatus status;
     private Date dataCriacao;

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }
}
