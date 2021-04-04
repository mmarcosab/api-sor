package br.com.sor.app.gateway;

import br.com.sor.app.gateway.database.PedidoBalcaoData;
import br.com.sor.app.gateway.database.PedidoDeliveryData;
import br.com.sor.app.gateway.database.PedidoSalaoData;

import java.util.List;
import java.util.Optional;

public interface PedidoGateway {

    PedidoSalaoData savePedidoSalao(PedidoSalaoData pedido) throws Exception;
    List<PedidoSalaoData> getAllPedidosSalao();
    Optional<PedidoSalaoData> getPedidoSalaoById(Integer id);
    PedidoSalaoData updatePedidoSalao(PedidoSalaoData pedidoSalaoData)throws Exception;
    void deletePedidoSalao(Integer id);
    Optional<PedidoSalaoData> getPedidoSalaoByNumeroMesa(Integer id);

    PedidoDeliveryData savePedidoDelivery(PedidoDeliveryData pedidoDeliveryData);
    List<PedidoDeliveryData> getAllPedidosDelivery();
    Optional<PedidoDeliveryData> getPedidoDeliveryById(Integer id);
    PedidoDeliveryData updatePedidoDelivery(PedidoDeliveryData pedidoNovo)throws Exception;
    void deletePedidoDelivery(Integer id);

    PedidoBalcaoData savePedidoBalcao(PedidoBalcaoData pedidoBalcaoData);
    List<PedidoBalcaoData> getAllPedidosBalcao();
    Optional<PedidoBalcaoData> getPedidoBalcaoById(Integer id);
    PedidoBalcaoData updatePedidoBalcao(PedidoBalcaoData pedidoNovo)throws Exception;
    void deletePedidoBalcao(Integer id);

}
