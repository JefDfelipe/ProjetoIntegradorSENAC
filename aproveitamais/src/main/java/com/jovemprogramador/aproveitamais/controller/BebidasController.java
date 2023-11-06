package com.jovemprogramador.aproveitamais.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jovemprogramador.aproveitamais.models.Bebidas;
import com.jovemprogramador.aproveitamais.repository.BebidasRepository;



@Controller
public class BebidasController {


	@Autowired
	BebidasRepository br;
    
 @RequestMapping("/bebidas")
	 public ModelAndView bebidas(){
	 ModelAndView mv = new ModelAndView("home/bebidas");
	 Iterable<Bebidas> bebidas = br.findAll();
	 mv.addObject("Bebidas", bebidas);
	 return mv;
	}

}
