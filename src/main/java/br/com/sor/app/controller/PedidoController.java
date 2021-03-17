package br.com.sor.app.controller;

import br.com.sor.app.entity.Pedido;
import br.com.sor.app.gateway.PedidoGateway;
import br.com.sor.app.gateway.database.PedidoData;
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
@RequestMapping("pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoGateway pedidoGateway;
    private final PedidoDataConverter pedidoDataConverter;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Pedido pedido){
        log.info("Payload recebido: {}", pedido);
        try {
            pedidoGateway.save(pedidoDataConverter.convert(pedido));
            return ResponseEntity.ok().body(pedido);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<PedidoData> pedidos = new ArrayList<>();
        pedidos = pedidoGateway.getAll();
        return ResponseEntity.ok().body(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        Optional<PedidoData> produtoData = pedidoGateway.getById(id);
        if(produtoData.isEmpty())  {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(produtoData);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Pedido pedido){
        try {
            return ResponseEntity.ok().body(pedidoGateway.update(pedidoDataConverter.convert(pedido)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        pedidoGateway.delete(id);
    }

}
