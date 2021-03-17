package br.com.sor.app.gateway.impl;

import br.com.sor.app.entity.Pedido;
import br.com.sor.app.gateway.PedidoGateway;
import br.com.sor.app.gateway.database.PedidoData;
import br.com.sor.app.gateway.database.ProdutoData;
import br.com.sor.app.gateway.database.repository.PedidoRepository;
import br.com.sor.app.gateway.database.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class PedidoGatewayImpl implements PedidoGateway {

    private final PedidoRepository pedidoRepository;

    public PedidoData save(PedidoData pedidoData){
        log.debug("Armazenando produto: {}", pedidoData);
        return pedidoRepository.save(pedidoData);
    }

    public List<PedidoData> getAll(){
        log.debug("Buscando todos os pedidos cadastrados");
        return pedidoRepository.findAll();
    }

    public Optional<PedidoData> getById(Integer id){
        log.debug("Buscando pedido por id {}", id);
        return pedidoRepository.findById(id);
    }

    public PedidoData update(PedidoData pedidoData)throws Exception {
        log.debug("Buscando produto por id {}", pedidoData.getId());
        //TODO - add itens ao pedido
        return new PedidoData();

    }

}
