package com.jovemprogramador.aproveitamais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jovemprogramador.aproveitamais.models.PessoaFisica;
import com.jovemprogramador.aproveitamais.models.PessoaJuridica;
import com.jovemprogramador.aproveitamais.models.PessoaFisica;

public interface UsuarioRepository extends JpaRepository<PessoaJuridica, String> {
    

        PessoaJuridica findByLoginPJ(String login);

        PessoaFisica findByLoginPF(String login);

}
