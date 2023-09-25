package com.jovemprogramador.aproveitamais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jovemprogramador.aproveitamais.models.PessoaJuridica;
import com.jovemprogramador.aproveitamais.models.UsuarioCliente;
<<<<<<< HEAD
=======

>>>>>>> 45319b08c57ae2ba6e51deb3299819f445adc56f

public interface UsuarioRepository extends JpaRepository<PessoaJuridica, String> {
    

        PessoaJuridica findByLoginPJ(String login);

        UsuarioCliente findByLoginPF(String login);

}
