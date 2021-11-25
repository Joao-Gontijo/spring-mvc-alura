package br.com.alura.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repositoy.PedidoRepository;

@Controller
@RequestMapping("/pedido") //mapeia todos os tipos de requisição
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido requisicao) {
		return "pedido/formulario";
	}
	
	@PostMapping("novo") //@Valid para validar lá na requisição
	public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
		if(result.hasErrors()) { //Binding
			return "pedido/formulario";
		}
		
		Pedido pedido = requisicao.toPedido(); //criar método .toPedido() na dto
		pedidoRepository.save(pedido);
		return "pedido/formulario";
	}
}
