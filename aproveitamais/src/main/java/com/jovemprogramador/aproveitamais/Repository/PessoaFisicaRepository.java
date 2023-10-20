package com.jovemprogramador.aproveitamais.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jovemprogramador.aproveitamais.models.PessoaFisica;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, UUID> {

    PessoaFisica findByLogin(String login);
}
