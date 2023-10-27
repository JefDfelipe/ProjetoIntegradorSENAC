package com.jovemprogramador.aproveitamais.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/alimentos")
public class AlimentosController {
    
	@GetMapping("/energetico")
	public String  Bebidas(){
		return "energetico";
	}

}