package br.com.sor.app.gateway.database.converter;

import br.com.sor.app.entity.PedidoBalcao;
import br.com.sor.app.entity.PedidoSalao;
import br.com.sor.app.entity.PedidoDelivery;
import br.com.sor.app.gateway.database.PedidoBalcaoData;
import br.com.sor.app.gateway.database.PedidoDeliveryData;
import br.com.sor.app.gateway.database.PedidoSalaoData;
import br.com.sor.app.gateway.database.ProdutoData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PedidoDataConverter {

    private final ProdutoDataConverter produtoDataConverter;
    private final ClienteDataConverter clienteDataConverter;

    public PedidoSalaoData convert(PedidoSalao pedidoSalao){

        PedidoSalaoData pedidoSalaoData = new PedidoSalaoData();
        List<ProdutoData> produtosData = new ArrayList<>();

        if(pedidoSalao.getCodigo() > 0) {
            pedidoSalaoData.setId(pedidoSalao.getCodigo());
        }
        pedidoSalaoData.setNumeroMesa(pedidoSalao.getNumeroMesa());
        pedidoSalaoData.setProdutos(produtoDataConverter.convert(pedidoSalao.getProdutos()));
        pedidoSalaoData.setTotal(pedidoSalao.getTotal());

        return pedidoSalaoData;

    }

    public PedidoBalcaoData convert(PedidoBalcao pedidoBalcao){

        PedidoBalcaoData pedidoBalcaoData = new PedidoBalcaoData();
        List<ProdutoData> produtosData = new ArrayList<>();

        if(pedidoBalcao.getCodigo() > 0){
            pedidoBalcaoData.setId(pedidoBalcao.getCodigo());
        }
        pedidoBalcaoData.setNomeCliente(pedidoBalcao.getNomeCliente());
        pedidoBalcaoData.setTotal(pedidoBalcao.getTotal());
        pedidoBalcaoData.setProdutos(produtoDataConverter.convert(pedidoBalcao.getProdutos()));

        return pedidoBalcaoData;

    }

    public PedidoDeliveryData convert(PedidoDelivery pedidoDelivery){

        PedidoDeliveryData pedidoDeliveryData = new PedidoDeliveryData();
        List<ProdutoData> produtosData = new ArrayList<>();

        if(pedidoDelivery.getCodigo() > 0){
            pedidoDeliveryData.setId(pedidoDelivery.getCodigo());
        }
        pedidoDeliveryData.setProdutos(produtoDataConverter.convert(pedidoDelivery.getProdutos()));
        pedidoDeliveryData.setCliente(clienteDataConverter.convert(pedidoDelivery.getCliente()));
        pedidoDeliveryData.setTotal(pedidoDelivery.getTotal());

        return pedidoDeliveryData;

    }

}

