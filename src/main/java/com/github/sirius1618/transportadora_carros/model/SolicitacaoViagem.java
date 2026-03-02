package com.github.sirius1618.transportadora_carros.model;

import jakarta.persistence.*;

@Entity
public class SolicitacaoViagem {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @ManyToOne
     private Passageiro passageiro;
     private String origem;
     private String destino;
}
