package com.jovemprogramador.aproveitamais.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jovemprogramador.aproveitamais.models.PessoaFisica;
import com.jovemprogramador.aproveitamais.models.PessoaJuridica;
import com.jovemprogramador.aproveitamais.models.Produtos;
import com.jovemprogramador.aproveitamais.repository.PessoaFisicaRepository;
import com.jovemprogramador.aproveitamais.repository.PessoaJuridicaRepository;
import com.jovemprogramador.aproveitamais.repository.ProdutosRepository;

import jakarta.validation.Valid;

@Controller
public class appController {

    @Autowired
    private PessoaFisicaRepository pf;
	private PessoaJuridicaRepository pj;
	private ProdutosRepository pr;

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
		public String formPF(@Valid PessoaFisica pessoaFisica, BindingResult result, 
				RedirectAttributes attributes) {
			
			if(result.hasErrors()) {
				attributes.addFlashAttribute("mensagem", "Verifique os campos!");
				return "redirect:/cadastro";
			}
			pf.save(pessoaFisica);
			attributes.addFlashAttribute("mensagem", "Concluido");
			return "redirect:/login";
		}


		

	//@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
		//public String formPJ(@Valid PessoaJuridica pessoaJuridica, BindingResult result, 
		//		RedirectAttributes attributes) {
		// 	if(result.hasErrors()) {
		// 		attributes.addFlashAttribute("mensagem", "Verifique os campos!");
		// 		return "redirect:/cadastro";
		// 	}
		// 	pj.save(pessoaJuridica);
		// 	attributes.addFlashAttribute("mensagem", "Concluido");
		// 	return "redirect:/login";
		// }
	@RequestMapping("/todososprodutos")
	public ModelAndView todosOsProdutos(){
		ModelAndView mv = new ModelAndView("home/todososprodutos");
		Iterable<Produtos> produtos = pr.findAll();
		mv.addObject("Produtos", produtos);
		return mv;
	}

    @RequestMapping("/bebidas")
	public ModelAndView bebidas(){
		ModelAndView mv = new ModelAndView("home/bebidas");
		Iterable<Produtos> bebidas = pr.findAll();
		mv.addObject("Bebidas", bebidas);
		return mv;
	}    

}