package com.jovemprogramador.aproveitamais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jovemprogramador.aproveitamais.models.PessoaJuridica;
import com.jovemprogramador.aproveitamais.models.UsuarioCliente;


public interface UsuarioRepository extends JpaRepository<PessoaJuridica, String> {
    

        PessoaJuridica findByLogin(String login);

        UsuarioCliente findByLogin(String login);

}
