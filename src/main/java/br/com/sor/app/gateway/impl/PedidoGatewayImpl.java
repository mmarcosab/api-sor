package br.com.sor.app.gateway.impl;

import br.com.sor.app.gateway.PedidoGateway;
import br.com.sor.app.gateway.database.PedidoBalcaoData;
import br.com.sor.app.gateway.database.PedidoDeliveryData;
import br.com.sor.app.gateway.database.PedidoSalaoData;
import br.com.sor.app.gateway.database.repository.PedidoBalcaoRepository;
import br.com.sor.app.gateway.database.repository.PedidoDeliveryRepository;
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
    private final PedidoBalcaoRepository pedidoBalcaoRepository;
    private final PedidoDeliveryRepository pedidoDeliveryRepository;

    /* Pedidos vindos do salao*/

    @Override
    public PedidoSalaoData savePedidoSalao(PedidoSalaoData pedidoSalaoData){
        log.debug("Armazenando produto: {}", pedidoSalaoData);
        return pedidoSalaoRepository.save(pedidoSalaoData);
    }

    @Override
    public List<PedidoSalaoData> getAllPedidosSalao(){
        log.debug("Buscando todos os pedidos cadastrados");
        return pedidoSalaoRepository.findAll();
    }

    @Override
    public Optional<PedidoSalaoData> getPedidoSalaoById(Integer id){
        log.debug("Buscando pedido por id {}", id);
        return pedidoSalaoRepository.findById(id);
    }

    @Override
    public PedidoSalaoData updatePedidoSalao(PedidoSalaoData pedidoNovo)throws Exception {
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
    public void deletePedidoSalao(Integer id){
        pedidoSalaoRepository.deleteById(id);
    }

    /* Pedidos viagem */

    @Override
    public PedidoDeliveryData savePedidoDelivery(PedidoDeliveryData pedidoDeliveryData){
        log.debug("Armazenando pedido balcao: {}", pedidoDeliveryData);
        return pedidoDeliveryRepository.save(pedidoDeliveryData);
    }

    @Override
    public List<PedidoDeliveryData> getAllPedidosDelivery(){
        log.debug("Buscando todos os pedidos feitos para viagem cadastrados");
        return pedidoDeliveryRepository.findAll();
    }

    @Override
    public Optional<PedidoDeliveryData> getPedidoDeliveryById(Integer id){
        log.debug("Buscando pedido por id {}", id);
        return pedidoDeliveryRepository.findById(id);
    }

    @Override
    public PedidoDeliveryData updatePedidoDelivery(PedidoDeliveryData pedidoNovo)throws Exception {
        log.debug("Buscando pedido por id {}", pedidoNovo.getId());
        Optional<PedidoDeliveryData> pedidoExistente = pedidoDeliveryRepository.findById(pedidoNovo.getId());

        if(!pedidoExistente.isEmpty()){
           //TODO
           pedidoDeliveryRepository.save(pedidoExistente.get());
        }
        return pedidoNovo;
    }

    @Override
    public void deletePedidoDelivery(Integer id){
        pedidoBalcaoRepository.deleteById(id);
    }


    /* Pedidos delivery */


    @Override
    public PedidoBalcaoData savePedidoBalcao(PedidoBalcaoData pedidoBalcaoData){
        log.debug("Armazenando pedido balcao: {}", pedidoBalcaoData);
        return pedidoBalcaoRepository.save(pedidoBalcaoData);
    }

    @Override
    public List<PedidoBalcaoData> getAllPedidosBalcao(){
        log.debug("Buscando todos os pedidos feitos para viagem cadastrados");
        return pedidoBalcaoRepository.findAll();
    }

    @Override
    public Optional<PedidoBalcaoData> getPedidoBalcaoById(Integer id){
        log.debug("Buscando pedido por id {}", id);
        return pedidoBalcaoRepository.findById(id);
    }

    @Override
    public PedidoBalcaoData updatePedidoBalcao(PedidoBalcaoData pedidoNovo)throws Exception {
        log.debug("Buscando pedido por id {}", pedidoNovo.getId());
        Optional<PedidoBalcaoData> pedidoExistente = pedidoBalcaoRepository.findById(pedidoNovo.getId());
        if(!pedidoExistente.isEmpty()){
            pedidoExistente.get().setId(pedidoNovo.getId());
            pedidoExistente.get().setTotal(pedidoNovo.getTotal());
            pedidoExistente.get().setProdutos(pedidoNovo.getProdutos());
            pedidoExistente.get().setNomeCliente(pedidoNovo.getNomeCliente());
            pedidoBalcaoRepository.save(pedidoExistente.get());
        }
        return pedidoNovo;
    }

    @Override
    public void deletePedidoBalcao(Integer id){
        pedidoBalcaoRepository.deleteById(id);
    }


}
