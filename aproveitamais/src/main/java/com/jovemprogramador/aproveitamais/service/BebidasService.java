package com.jovemprogramador.aproveitamais.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.jovemprogramador.aproveitamais.models.Bebidas;
import com.jovemprogramador.aproveitamais.repository.BebidasRepository;



@Service
public class BebidasService {

    @Autowired
    private BebidasRepository Br;
    
	public ModelAndView bebidas(){
		ModelAndView mv = new ModelAndView("home/bebidas");
		Iterable<Bebidas> bebidas = Br.findAll();
		mv.addObject("Bebidas", bebidas);
		return mv;
	}
}
