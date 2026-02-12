package com.github.sirius1618.transportadora_carros.interfaces;

import com.github.sirius1618.transportadora_carros.model.Passageiro;
import com.github.sirius1618.transportadora_carros.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import java.awt.*;

@RestController
@RequestMapping(path = "/passageiro", produces = MediaType.APPLICATION_JSON_VALUE)
public class PassageiroAPI {

    @Autowired
    PassageiroRepository passageiroRepository;

    @GetMapping
    public List<Passageiro> listarPassagiros() {
        return passageiroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Passageiro buscaPassageiro(@PathVariable("id") Long id) {
        return passageiroRepository.findById(id).orElseThrow(() -> new
                ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Passageiro cadastrarPassageiro (@RequestBody Passageiro passageiro) {
        return passageiroRepository.save(passageiro);
    }

    @PutMapping("/{id}")
    public Passageiro atualizarTotalDadosPassageiro(@PathVariable Long id, @RequestBody Passageiro passageiro) {
       Passageiro atualizarPassageiro = buscaPassageiro(id);
       atualizarPassageiro.setNome(passageiro.getNome());
       return passageiroRepository.save(atualizarPassageiro);
    }

    @DeleteMapping("/{id}")
    public void removerPassageiro (@PathVariable("id") Long id) {
        passageiroRepository.deleteById(id);
    }

}
