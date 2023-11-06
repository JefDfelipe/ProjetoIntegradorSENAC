package com.jovemprogramador.aproveitamais.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jovemprogramador.aproveitamais.models.PessoaFisica;
import com.jovemprogramador.aproveitamais.repository.PessoaFisicaRepository;

import jakarta.validation.Valid;


@Controller
public class Pf_Controller {
    
	@Autowired
	private PessoaFisicaRepository pf;

	@RequestMapping(value = "/cadastroPF", method = RequestMethod.POST)
	public String formPF(@Valid PessoaFisica pessoaFisica, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastro";
		}
		pf.save(pessoaFisica);
		attributes.addFlashAttribute("mensagem", "Concluido");
		return "redirect:/login";
	}

}