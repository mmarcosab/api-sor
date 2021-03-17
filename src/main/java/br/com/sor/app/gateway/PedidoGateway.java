package br.com.sor.app.gateway;

import br.com.sor.app.gateway.database.PedidoData;

import java.util.List;
import java.util.Optional;

public interface PedidoGateway {
    PedidoData save(PedidoData pedido);
    List<PedidoData> getAll();
    Optional<PedidoData> getById(Integer id);
    PedidoData update(PedidoData pedidoData)throws Exception;
}
