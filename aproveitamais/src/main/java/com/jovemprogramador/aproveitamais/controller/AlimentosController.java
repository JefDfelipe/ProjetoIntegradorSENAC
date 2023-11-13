package com.jovemprogramador.aproveitamais.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jovemprogramador.aproveitamais.models.Alimentos;
import com.jovemprogramador.aproveitamais.repository.AlimentosRepository;

@Controller
public class AlimentosController {

	@Autowired
	AlimentosRepository ar;

	@RequestMapping("/alimentos")
	public ModelAndView alimentos() {
		ModelAndView mv = new ModelAndView("home/alimentos");
		Iterable<Alimentos> alimentos = ar.findAll();
		mv.addObject("Alimentos", alimentos);
		return mv;
	}

}