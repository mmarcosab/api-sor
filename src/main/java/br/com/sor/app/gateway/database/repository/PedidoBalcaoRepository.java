package br.com.sor.app.gateway.database.repository;

import br.com.sor.app.gateway.database.PedidoBalcaoData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoBalcaoRepository extends JpaRepository<PedidoBalcaoData, Integer> {

}
