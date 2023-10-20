package com.jovemprogramador.aproveitamais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jovemprogramador.aproveitamais.models.PessoaFisica;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, String> {

  PessoaFisica findByLogin(String login);
}
