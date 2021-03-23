package br.com.sor.app.controller.converter;

import br.com.sor.app.entity.PedidoBalcao;
import br.com.sor.app.entity.PedidoDelivery;
import br.com.sor.app.entity.PedidoSalao;
import br.com.sor.app.gateway.database.PedidoBalcaoData;
import br.com.sor.app.gateway.database.PedidoDeliveryData;
import br.com.sor.app.gateway.database.PedidoSalaoData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class PedidoConverter {

    private final ProdutoConverter produtoConverter;
    private final ClienteConverter clienteConverter;

    public PedidoSalao convert(PedidoSalaoData pedidoSalaoData){

        PedidoSalao pedidoSalao = new PedidoSalao();

        pedidoSalao.setCodigo(pedidoSalaoData.getId());
        pedidoSalao.setNumeroMesa(pedidoSalaoData.getNumeroMesa());
        pedidoSalao.setProdutos(produtoConverter.convert(pedidoSalaoData.getProdutos()));
        pedidoSalao.setTotal(pedidoSalaoData.getTotal());

        return pedidoSalao;

    }

    public PedidoBalcao convert(PedidoBalcaoData pedidoBalcaoData){

        PedidoBalcao pedidoBalcao = new PedidoBalcao();

        pedidoBalcao.setCodigo(pedidoBalcaoData.getId());
        pedidoBalcao.setNomeCliente(pedidoBalcaoData.getNomeCliente());
        pedidoBalcao.setTotal(pedidoBalcaoData.getTotal());
        pedidoBalcao.setProdutos(produtoConverter.convert(pedidoBalcaoData.getProdutos()));

        return pedidoBalcao;

    }

    public PedidoDelivery convert(PedidoDeliveryData pedidoDeliveryData){

        PedidoDelivery pedidoDelivery = new PedidoDelivery();

        pedidoDelivery.setCodigo(pedidoDeliveryData.getId());
        pedidoDelivery.setProdutos(produtoConverter.convert(pedidoDeliveryData.getProdutos()));
        pedidoDelivery.setCliente(clienteConverter.convert(pedidoDeliveryData.getCliente()));
        pedidoDelivery.setTotal(pedidoDeliveryData.getTotal());

        return pedidoDelivery;

    }

}

