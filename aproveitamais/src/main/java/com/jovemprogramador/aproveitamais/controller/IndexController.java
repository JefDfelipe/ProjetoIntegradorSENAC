package com.jovemprogramador.aproveitamais.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/cadastro")
	public String cadastro() {
		return "home/cadastro";
	}

	@RequestMapping("/cart")
	public String cart() {
		return "home/cart";
	}

	@RequestMapping("/detalhesproduto")
	public String detalhesproduto() {
		return "home/detalhesproduto";
	}

	@RequestMapping("/checkout")
	public String checkout() {
		return "home/checkout";
	}

}