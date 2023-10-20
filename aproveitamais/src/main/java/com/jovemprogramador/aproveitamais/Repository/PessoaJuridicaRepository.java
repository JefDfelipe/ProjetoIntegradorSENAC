package com.jovemprogramador.aproveitamais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jovemprogramador.aproveitamais.models.PessoaJuridica;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, String> {

        PessoaJuridica findByLogin(String login);

}
