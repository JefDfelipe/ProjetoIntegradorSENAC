package com.jovemprogramador.aproveitamais.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jovemprogramador.aproveitamais.models.Alimentos;
import com.jovemprogramador.aproveitamais.repository.AlimentosRepository;

public class AlimentosService {
    
@Autowired
	private AlimentosRepository Ar;
	
	@RequestMapping("/todososprodutos")
	public ModelAndView todosOsProdutos(){
		ModelAndView mv = new ModelAndView("home/todososprodutos");
		Iterable<Alimentos> alimentos = Ar.findAll();
		mv.addObject("Alimentos", alimentos);
		return mv;
	}


}