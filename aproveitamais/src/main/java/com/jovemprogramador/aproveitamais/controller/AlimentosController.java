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
	 public ModelAndView todosOsProdutos(){
	 ModelAndView mv = new ModelAndView("home/todososprodutos");
	 Iterable<Alimentos> produtos = ar.findAll();
	 mv.addObject("Produtos", produtos);
	 return mv;
	}

}