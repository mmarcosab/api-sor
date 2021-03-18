package br.com.sor.app.gateway.database.repository;

import br.com.sor.app.gateway.database.PedidoDeliveryData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoDeliveryRepository extends JpaRepository<PedidoDeliveryData, Integer> {

}
