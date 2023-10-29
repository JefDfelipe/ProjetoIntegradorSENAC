package com.jovemprogramador.aproveitamais.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jovemprogramador.aproveitamais.models.Alimentos;
import com.jovemprogramador.aproveitamais.models.Categoria;
import com.jovemprogramador.aproveitamais.repository.AlimentosRepository;

public class AlimentosService {

	private AlimentosRepository ar;

	@Autowired
	public AlimentosService(AlimentosRepository ar_) {
		this.ar = ar_;
	}

	public Alimentos findById(UUID id) {

		Optional<Alimentos> alimentosOptional = ar.findById(id);
		return alimentosOptional.orElse(null);

		// return ar.findById(id);
	}

	public Alimentos cadastrarAlimento(Alimentos novoAlimento) {

		Optional<Alimentos> jaExistente = ar.findById(novoAlimento.getId());

		if (jaExistente.isPresent()) {
			String msg = "Alimento já cadastrado";

			throw new IllegalStateException(msg);
		}

		return ar.save(novoAlimento);
	}

	// @RequestMapping("/todososprodutos")
	// public ModelAndView todosOsProdutos() {
	// ModelAndView mv = new ModelAndView("home/todososprodutos");
	// Iterable<Alimentos> alimentos = ar.findAll();
	// mv.addObject("Alimentos", alimentos);
	// return mv;
	// }

}