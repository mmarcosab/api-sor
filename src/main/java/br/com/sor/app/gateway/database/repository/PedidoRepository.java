package br.com.sor.app.gateway.database.repository;

import br.com.sor.app.gateway.database.PedidoData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoData, Integer> {

}
