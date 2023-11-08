package com.jovemprogramador.aproveitamais.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jovemprogramador.aproveitamais.models.Bebidas;
import com.jovemprogramador.aproveitamais.repository.BebidasRepository;



@Service
public class BebidasService {

    private BebidasRepository br;

	@Autowired
	public BebidasService(BebidasRepository br_) {
		this.br = br_;
	}

	public Bebidas findById(UUID Id) {

		Optional<Bebidas> bebidasOptional = br.findById(Id);
		return bebidasOptional.orElse(null);

		// return ar.findById(id);
	}

	public Bebidas cadastrarBebidas(Bebidas novoBebidas) {

		Optional<Bebidas> jaExistente = br.findById(novoBebidas.getBebidasId());

		if (jaExistente.isPresent()) {
			String msg = "Bebida já cadastrada";

			throw new IllegalStateException(msg);
		}

		return br.save(novoBebidas);
	}
}
