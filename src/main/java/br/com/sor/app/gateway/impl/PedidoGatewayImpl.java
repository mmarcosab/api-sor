package br.com.sor.app.gateway.impl;

import br.com.sor.app.gateway.PedidoGateway;
import br.com.sor.app.gateway.database.PedidoSalaoData;
import br.com.sor.app.gateway.database.repository.PedidoSalaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class PedidoGatewayImpl implements PedidoGateway {

    private final PedidoSalaoRepository pedidoSalaoRepository;

    @Override
    public PedidoSalaoData save(PedidoSalaoData pedidoSalaoData){
        log.debug("Armazenando produto: {}", pedidoSalaoData);
        return pedidoSalaoRepository.save(pedidoSalaoData);
    }

    @Override
    public List<PedidoSalaoData> getAll(){
        log.debug("Buscando todos os pedidos cadastrados");
        return pedidoSalaoRepository.findAll();
    }

    @Override
    public Optional<PedidoSalaoData> getById(Integer id){
        log.debug("Buscando pedido por id {}", id);
        return pedidoSalaoRepository.findById(id);
    }

    @Override
    public PedidoSalaoData update(PedidoSalaoData pedidoNovo)throws Exception {
        log.debug("Buscando produto por id {}", pedidoNovo.getId());
        Optional<PedidoSalaoData> pedidoExistente = pedidoSalaoRepository.findById(pedidoNovo.getId());
        if(!pedidoExistente.isEmpty()){
            pedidoExistente.get().setId(pedidoNovo.getId());
            pedidoExistente.get().setTotal(pedidoNovo.getTotal());
            pedidoExistente.get().setTipoPedido(pedidoNovo.getTipoPedido());
            pedidoExistente.get().setProdutos(pedidoNovo.getProdutos());
            pedidoSalaoRepository.save(pedidoExistente.get());
        }
        return pedidoNovo;
    }

    @Override
    public void delete(Integer id){
        pedidoSalaoRepository.deleteById(id);
    }

}
