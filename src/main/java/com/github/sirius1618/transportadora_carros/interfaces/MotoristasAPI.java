package com.github.sirius1618.transportadora_carros.interfaces;

import com.github.sirius1618.transportadora_carros.model.Motorista;
import com.github.sirius1618.transportadora_carros.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RestController
@RequestMapping(path = "/motoristas", produces = MediaType.APPLICATION_JSON_VALUE)
public class MotoristasAPI {

    @Autowired
    MotoristaRepository motoristaRepository;

    @GetMapping()
    public List<Motorista> listarMotoristas () {
        return motoristaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Motorista buscarMotorista (@PathVariable  Long id) {
        return motoristaRepository.findById(id).orElseThrow(() -> new
                ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public Motorista criarMotorista(@RequestBody Motorista motorista) {
        return motoristaRepository.save(motorista);
    }

    @PutMapping("/{id}")
    public Motorista atualizacaoTotalDadosMotorista (@PathVariable("id") Long id, @RequestBody Motorista motorista) {
        Motorista atualizacaoMotorista = buscarMotorista(id);
        atualizacaoMotorista.setDataNacimento(motorista.getDataNacimento());
        atualizacaoMotorista.setNome(motorista.getNome());
        return motoristaRepository.save(atualizacaoMotorista);
    }

    @PatchMapping("/{id}")
    public Motorista atualizarParteDadosMotorista (@PathVariable("id") Long id, @RequestBody Motorista motorista) {
        Motorista atulizarParteMotorista = buscarMotorista(id);
        atulizarParteMotorista.setDataNacimento(Optional.ofNullable(motorista.getDataNacimento()).orElse(atulizarParteMotorista.getDataNacimento()));
        atulizarParteMotorista.setNome(Optional.ofNullable(motorista.getNome()).orElse(atulizarParteMotorista.getNome()));
        return motoristaRepository.save(atulizarParteMotorista);
    }

    @DeleteMapping("/{id}")
    public void deletarMotorista (@PathVariable("id") Long id) {
        motoristaRepository.deleteById(id);
    }
}
