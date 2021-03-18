package br.com.sor.app.gateway;

import br.com.sor.app.gateway.database.PedidoSalaoData;

import java.util.List;
import java.util.Optional;

public interface PedidoGateway {
    PedidoSalaoData save(PedidoSalaoData pedido);
    List<PedidoSalaoData> getAll();
    Optional<PedidoSalaoData> getById(Integer id);
    PedidoSalaoData update(PedidoSalaoData pedidoSalaoData)throws Exception;
    void delete(Integer id);
}
