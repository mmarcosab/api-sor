package br.com.sor.app.gateway.database.converter;

import br.com.sor.app.entity.PedidoBalcao;
import br.com.sor.app.entity.PedidoSalao;
import br.com.sor.app.entity.PedidoDelivery;
import br.com.sor.app.entity.Produto;
import br.com.sor.app.gateway.database.PedidoBalcaoData;
import br.com.sor.app.gateway.database.PedidoDeliveryData;
import br.com.sor.app.gateway.database.PedidoSalaoData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;


@Component
@RequiredArgsConstructor
public class PedidoDataConverter {

    private final ProdutoDataConverter produtoDataConverter;
    private final ClienteDataConverter clienteDataConverter;

    public PedidoSalaoData convert(PedidoSalao pedidoSalao){

        PedidoSalaoData pedidoSalaoData = new PedidoSalaoData();

        if(pedidoSalao.getCodigo() > 0) {
            pedidoSalaoData.setId(pedidoSalao.getCodigo());
        }
        pedidoSalaoData.setNumeroMesa(pedidoSalao.getNumeroMesa());
        pedidoSalaoData.setProdutos(produtoDataConverter.convert(pedidoSalao.getProdutos()));
        Double totalPedido = 0.0;
        for(Produto p : pedidoSalao.getProdutos()){
            totalPedido += p.getPreco().doubleValue();
        }
        pedidoSalaoData.setStatus(pedidoSalao.getStatus());
        pedidoSalaoData.setTotal(new BigDecimal(totalPedido));

        return pedidoSalaoData;

    }

    public PedidoBalcaoData convert(PedidoBalcao pedidoBalcao){

        PedidoBalcaoData pedidoBalcaoData = new PedidoBalcaoData();

        if(pedidoBalcao.getCodigo() > 0){
            pedidoBalcaoData.setId(pedidoBalcao.getCodigo());
        }
        pedidoBalcaoData.setNomeCliente(pedidoBalcao.getNomeCliente());
        pedidoBalcaoData.setProdutos(produtoDataConverter.convert(pedidoBalcao.getProdutos()));
        Double totalPedido = 0.0;
        for(Produto p : pedidoBalcao.getProdutos()){
            totalPedido += p.getPreco().doubleValue();
        }
        pedidoBalcaoData.setTotal(new BigDecimal(totalPedido));

        return pedidoBalcaoData;

    }

    public PedidoDeliveryData convert(PedidoDelivery pedidoDelivery){

        PedidoDeliveryData pedidoDeliveryData = new PedidoDeliveryData();

        if(pedidoDelivery.getCodigo() > 0){
            pedidoDeliveryData.setId(pedidoDelivery.getCodigo());
        }
        pedidoDeliveryData.setProdutos(produtoDataConverter.convert(pedidoDelivery.getProdutos()));
        pedidoDeliveryData.setCliente(clienteDataConverter.convert(pedidoDelivery.getCliente()));
        pedidoDeliveryData.setTotal(pedidoDelivery.getTotal());
        Double totalPedido = 0.0;
        for(Produto p : pedidoDelivery.getProdutos()){
            totalPedido += p.getPreco().doubleValue();
        }
        pedidoDeliveryData.setTotal(new BigDecimal(totalPedido));
        return pedidoDeliveryData;

    }

}

