package com.github.sirius1618.transportadora_carros.repository;

import com.github.sirius1618.transportadora_carros.model.Passageiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassageiroRepository extends JpaRepository <Passageiro, Long> {
}
