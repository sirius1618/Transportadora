package com.github.sirius1618.transportadora_carros.repository;

import com.github.sirius1618.transportadora_carros.model.Motorista;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoristaRepository extends JpaRepository <Motorista, Long> {
}
