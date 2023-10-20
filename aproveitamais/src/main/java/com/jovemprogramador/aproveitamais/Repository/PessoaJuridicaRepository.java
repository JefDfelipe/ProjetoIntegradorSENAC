package com.jovemprogramador.aproveitamais.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jovemprogramador.aproveitamais.models.PessoaJuridica;


public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, UUID> {
    

        PessoaJuridica findByLogin(String login);

        

}


