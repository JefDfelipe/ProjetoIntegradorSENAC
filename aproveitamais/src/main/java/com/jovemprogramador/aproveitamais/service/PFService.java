package com.jovemprogramador.aproveitamais.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jovemprogramador.aproveitamais.models.PessoaFisica;
import com.jovemprogramador.aproveitamais.repository.PessoaFisicaRepository;

@Service
public class PFService {

  PessoaFisicaRepository pf;

  @Autowired
  public PFService(PessoaFisicaRepository pf_) {
    this.pf = pf_;
  }

  public PessoaFisica findById(UUID Id) {
    Optional<PessoaFisica> pessoaOptional = pf.findById(Id);
    return pessoaOptional.orElse(null);

    // return pf.findById(Id);
  }

  public PessoaFisica cadastrarPessoaFisica(PessoaFisica novaPessoaFisica) {

    Optional<PessoaFisica> jaExistente = pf.findById(novaPessoaFisica.getClientId());

    if (jaExistente.isPresent()) {
      String msg = "Pessoa já cadastrada";

      throw new IllegalStateException(msg);
    }

    return pf.save(novaPessoaFisica);
  }

}
