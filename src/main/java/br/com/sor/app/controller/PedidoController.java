package br.com.sor.app.controller;

import br.com.sor.app.controller.converter.PedidoConverter;
import br.com.sor.app.entity.*;
import br.com.sor.app.gateway.PedidoGateway;
import br.com.sor.app.gateway.database.PedidoBalcaoData;
import br.com.sor.app.gateway.database.PedidoDeliveryData;
import br.com.sor.app.gateway.database.PedidoSalaoData;
import br.com.sor.app.gateway.database.converter.PedidoDataConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    private final PedidoConverter pedidoConverter;

    /* Pedidos vindos do salao*/

    @PostMapping("/salao")
    public ResponseEntity<?> createPedidoSalao(@RequestBody PedidoSalao pedidoSalao){
        log.info("Payload recebido: {}", pedidoSalao);
        try {
            return ResponseEntity.ok().body(pedidoGateway.savePedidoSalao(pedidoDataConverter.convert(pedidoSalao)));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/salao")
    public ResponseEntity<?> getAllPedidosSalao(){
        try {
            List<PedidoSalaoData> pedidos = new ArrayList<>();
            pedidos = pedidoGateway.getAllPedidosSalao();
            return ResponseEntity.ok().body(pedidos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Houve um erro ao tratar a requisicao. Erro: " + e.getMessage());
        }

    }

    @GetMapping("/salao/{id}")
    public ResponseEntity<?> getPedidoSalaoById(@PathVariable Integer id){
        try {
            Optional<PedidoSalaoData> produtoData = pedidoGateway.getPedidoSalaoById(id);
            if(produtoData.isEmpty())  {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok().body(produtoData);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Houve um erro ao tratar a requisicao. Erro: " + e.getMessage());
        }
    }

    @PutMapping("/salao/{id}")
    public ResponseEntity<?> updatePedidoSalao(@RequestBody PedidoSalao pedidoSalao){
        try {
            return ResponseEntity.ok().body(pedidoGateway.updatePedidoSalao(pedidoDataConverter.convert(pedidoSalao)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/salao/{id}")
    public void deletePedidoSalao(@PathVariable Integer id){
        try {
            pedidoGateway.deletePedidoSalao(id);
        } catch (Exception e) {
            log.error("Houve um erro ao tratar a requisicao. Erro: " + e.getMessage());
        }
    }

    @GetMapping("/salao/fechar-conta/{numeroMesa}")
    public ResponseEntity<?> fecharConta(@PathVariable Integer numeroMesa){
        try {
            PedidoSalao pedidoSalao = pedidoConverter.convert(pedidoGateway.getPedidoSalaoByNumeroMesa(numeroMesa).get());
            pedidoSalao.setStatus(StatusPedidoSalao.FECHADO.getCodigo());
            pedidoGateway.savePedidoSalao(pedidoDataConverter.convert(pedidoSalao));
            return ResponseEntity.ok().body(pedidoSalao);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Houve um erro ao tratar a requisicao. Erro: " + e.getMessage());
        }
    }

    @GetMapping("/salao/pagar-conta/{numeroMesa}")
    public ResponseEntity<?> pagarConta(@PathVariable Integer numeroMesa){
        try {
            PedidoSalao pedidoSalao = pedidoConverter.convert(pedidoGateway.getPedidoSalaoByNumeroMesa(numeroMesa).get());
            pedidoSalao.setStatus(StatusPedidoSalao.PAGO.getCodigo());
            pedidoGateway.savePedidoSalao(pedidoDataConverter.convert(pedidoSalao));
            return ResponseEntity.ok().body(pedidoSalao);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Houve um erro ao tratar a requisicao. Erro: " + e.getMessage());
        }
    }

    /* Pedidos delivery */

    @PostMapping("/delivery")
    public ResponseEntity<?> createPedidoDelivery(@RequestBody PedidoDelivery pedidoDelivery){
        log.info(pedidoDelivery.toString());
        try {
            return ResponseEntity.ok().body(pedidoGateway.savePedidoDelivery(pedidoDataConverter.convert(pedidoDelivery)));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/delivery")
    public ResponseEntity<?> getAllPedidosDelivery(){
        try {
            List<PedidoDeliveryData> pedidos = new ArrayList<>();
            pedidos = pedidoGateway.getAllPedidosDelivery();
            return ResponseEntity.ok().body(pedidos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Houve um erro ao tratar a requisicao. Erro: " + e.getMessage());
        }
    }

    @GetMapping("/delivery/{id}")
    public ResponseEntity<?> getPedidoDeliveryById(@PathVariable Integer id){
        try {
            Optional<PedidoDeliveryData> pedidoDeliveryData = pedidoGateway.getPedidoDeliveryById(id);
            if(pedidoDeliveryData.isEmpty())  {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok().body(pedidoDeliveryData);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Houve um erro ao tratar a requisicao. Erro: " + e.getMessage());
        }
    }

    @PutMapping("/delivery/{id}")
    public ResponseEntity<?> updatePedidoDelivery(@RequestBody PedidoDelivery pedidoDelivery){
        try {
            return ResponseEntity.ok().body(pedidoGateway.updatePedidoDelivery(pedidoDataConverter.convert(pedidoDelivery)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delivery/{id}")
    public void deletePedidoDelivery(@PathVariable Integer id){
        try {
            pedidoGateway.deletePedidoDelivery(id);
        } catch (Exception e) {
            log.error("Houve um erro ao tratar a requisicao. Erro: " + e.getMessage());
        }
    }




    /* Pedidos  para viagem */

    @PostMapping("/balcao")
    public ResponseEntity<?> createPedidoBalcao(@RequestBody PedidoBalcao pedidoBalcao){
        log.info(pedidoBalcao.toString());
        try {
            return ResponseEntity.ok().body(pedidoGateway.savePedidoBalcao(pedidoDataConverter.convert(pedidoBalcao)));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/balcao")
    public ResponseEntity<?> getAllPedidosBalcao(){
        try {
            List<PedidoBalcaoData> pedidos = new ArrayList<>();
            pedidos = pedidoGateway.getAllPedidosBalcao();
            return ResponseEntity.ok().body(pedidos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Houve um erro ao tratar a requisicao. Erro: " + e.getMessage());
        }
    }

    @GetMapping("/balcao/{id}")
    public ResponseEntity<?> getPedidoBalcaoById(@PathVariable Integer id){
        try {
            Optional<PedidoBalcaoData> pedidoDeliveryData = pedidoGateway.getPedidoBalcaoById(id);
            if (pedidoDeliveryData.isEmpty()) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok().body(pedidoDeliveryData);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Houve um erro ao tratar a requisicao. Erro: " + e.getMessage());
        }
    }

    @PutMapping("/balcao/{id}")
    public ResponseEntity<?> updatePedidoBalcao(@RequestBody PedidoBalcao pedidoBalcao){
        try {
            return ResponseEntity.ok().body(pedidoGateway.updatePedidoBalcao(pedidoDataConverter.convert(pedidoBalcao)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/balcao/{id}")
    public void deletePedidoBalcao(@PathVariable Integer id){
        try {
            pedidoGateway.deletePedidoBalcao(id);
        } catch (Exception e) {
            log.error("Houve um erro ao tratar a requisicao. Erro: " + e.getMessage());
        }
    }

}
