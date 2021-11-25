package br.com.alura.mvc.mudi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.model.Pedido;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Xiaomi Redmi Note 8");
		pedido.setUrlImagem("https://a-static.mlcdn.com.br/1500x1500/celular-xiaomi-redmi-note-8-64gb-63-polegadas-4gb-ram-preto/lojaolist/olsoolvuc3g88t52/f28d409f0f3c77a0e6cd2bb2763f685c.jpg");
		pedido.setUrlProduto("https://www.magazineluiza.com.br/celular-xiaomi-redmi-note-8-64gb-63-polegadas-4gb-ram-preto/p/bkec6j88ke/te/red8/?&seller_id=lojaolist&utm_source=google&utm_medium=pla&utm_campaign=&partner_id=63402&&&utm_source=google&utm_medium=pla&utm_campaign=&partner_id=58984&gclid=CjwKCAiA4veMBhAMEiwAU4XRr32psVtdCFJvjoPXUkyr6mcQKpHwOVcWfI2WUIqt5Y9SyeFF340QSRoCaAcQAvD_BwE&gclsrc=aw.ds");
		pedido.setDescricao("Descrição qualquer do pedido");
		
		List<Pedido> pedidos = Arrays.asList(pedido);
		model.addAttribute("pedidos", pedidos);
		return "home";
	}
}
