package com.jovemprogramador.aproveitamais.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/bebidas")
public class BebidasController {
    
	@GetMapping("/energetico")
	public String  Bebidas(){
		return "energetico";
	}

}
