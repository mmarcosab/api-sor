package br.com.sor.app.controller;

import br.com.sor.app.entity.PedidoBalcao;
import br.com.sor.app.entity.PedidoSalao;
import br.com.sor.app.entity.PedidoDelivery;
import br.com.sor.app.gateway.PedidoGateway;
import br.com.sor.app.gateway.database.PedidoSalaoData;
import br.com.sor.app.gateway.database.converter.PedidoDataConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoGateway pedidoGateway;
    private final PedidoDataConverter pedidoDataConverter;

    @PostMapping("/salao")
    public ResponseEntity<?> cadastrar(@RequestBody PedidoSalao pedidoSalao){
        log.info("Payload recebido: {}", pedidoSalao);
        try {
            pedidoGateway.save(pedidoDataConverter.convert(pedidoSalao));
            return ResponseEntity.ok().body(pedidoSalao);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<PedidoSalaoData> pedidos = new ArrayList<>();
        pedidos = pedidoGateway.getAll();
        return ResponseEntity.ok().body(pedidos);
    }

    @GetMapping("/salao/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        Optional<PedidoSalaoData> produtoData = pedidoGateway.getById(id);
        if(produtoData.isEmpty())  {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(produtoData);
        }
    }

    @PutMapping("/salao/{id}")
    public ResponseEntity<?> update(@RequestBody PedidoSalao pedidoSalao){
        try {
            return ResponseEntity.ok().body(pedidoGateway.update(pedidoDataConverter.convert(pedidoSalao)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/salao/{id}")
    public void delete(@PathVariable Integer id){
        pedidoGateway.delete(id);
    }


    //TODO - pedido delivery

    @PostMapping("/delivery")
    public ResponseEntity<?> criar(@RequestBody PedidoDelivery pedidoDelivery){
        log.info(pedidoDelivery.toString());



        return ResponseEntity.ok().build();
    }

    //TODO - pedido balcao

    @PostMapping("/balcao")
    public ResponseEntity<?> criar(@RequestBody PedidoBalcao pedidoBalcao){
        log.info(pedidoBalcao.toString());

        return ResponseEntity.ok().build();
    }

}
