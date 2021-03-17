package br.com.sor.app.gateway.database.converter;//package br.com.sor.app.controller.converter;

import br.com.sor.app.entity.Pedido;
import br.com.sor.app.entity.Produto;
import br.com.sor.app.gateway.database.PedidoData;
import br.com.sor.app.gateway.database.ProdutoData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PedidoDataConverter {

    private final ProdutoDataConverter produtoDataConverter;

    public PedidoData convert(Pedido pedido){

        PedidoData pedidoData = new PedidoData();
        List<ProdutoData> produtosData = new ArrayList<>();

        pedidoData.setId(pedido.getCodigo());
        pedidoData.setProdutos(produtoDataConverter.convert(pedido.getProdutos()));
        pedidoData.setTipoPedido(pedido.getTipoPedido());
        pedidoData.setTotal(pedido.getTotal());

        return pedidoData;

    }

}
