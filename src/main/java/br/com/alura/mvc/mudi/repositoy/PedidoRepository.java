package br.com.alura.mvc.mudi.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.Pedido;

@Repository                                            //classe, tipo do Id
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	

}
