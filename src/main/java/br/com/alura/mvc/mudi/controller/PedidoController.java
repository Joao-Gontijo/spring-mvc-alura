package br.com.alura.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pedido") //mapeia todos os tipos de requisição
public class PedidoController {
	
	@GetMapping("formulario")
	public String formulario() {
		return "pedido/formulario";
	}
}
