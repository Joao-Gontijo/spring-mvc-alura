package br.com.alura.mvc.mudi.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.dto.RequisicaoNovaOferta;
import br.com.alura.mvc.mudi.model.Oferta;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repositoy.PedidoRepository;

@RestController
@RequestMapping("api/ofertas")
public class OfertasRest {

	@Autowired
	private PedidoRepository pedidoRepository; //para buscar o pedido no banco de dados
	
	@PostMapping
	public Oferta criaOferta(@RequestBody RequisicaoNovaOferta requisicao) {
		//Pode ou não encontrar um pedido				//buscando o pedido no banco pelo repository
		System.out.println(requisicao.getPedidoId());
		Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicao.getPedidoId());
		if(!pedidoBuscado.isPresent()) {
			return null;
		}
		Pedido pedido = pedidoBuscado.get();
		
		Oferta nova = requisicao.toOferta();
		nova.setPedido(pedido); 
		pedido.getOfertas().add(nova);
		pedidoRepository.save(pedido);
		
		return nova;
	}
}
