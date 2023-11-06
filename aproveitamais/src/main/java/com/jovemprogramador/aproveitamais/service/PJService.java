package com.jovemprogramador.aproveitamais.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jovemprogramador.aproveitamais.models.PessoaJuridica;
import com.jovemprogramador.aproveitamais.repository.PessoaJuridicaRepository;

import jakarta.validation.Valid;


@Service
public class PJService {
    

    @Autowired
    private PessoaJuridicaRepository pj;

    @RequestMapping(value = "/cadastroPJ", method = RequestMethod.POST)
		public String formPJ(@Valid PessoaJuridica pessoaJuridica, BindingResult result, 
				RedirectAttributes attributes) {
			if(result.hasErrors()) {
				attributes.addFlashAttribute("mensagem", "Verifique os campos!");
				return "redirect:/cadastro";
			}
			pj.save(pessoaJuridica);
			attributes.addFlashAttribute("mensagem", "Concluido");
			return "redirect:/login";
		}
}
