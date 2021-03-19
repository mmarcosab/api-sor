package br.com.sor.app.controller;

import br.com.sor.app.controller.converter.MercadoriaConverter;
import br.com.sor.app.entity.Mercadoria;
import br.com.sor.app.gateway.MercadoriaGateway;
import br.com.sor.app.gateway.database.MercadoriaData;
import br.com.sor.app.gateway.database.converter.MercadoriaDataConverter;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Component
@RequiredArgsConstructor
@RestController
@RequestMapping("/mercadoria")
public class MercadoriaController {

    private final MercadoriaGateway mercadoriaGateway;
    private final MercadoriaDataConverter mercadoriaDataConverter;
    private final MercadoriaConverter mercadoriaConverter;


    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Mercadoria mercadoria){
        log.info("Payload recebido: {}", mercadoria);
        try {
            Mercadoria mercadoriaArmazenada = mercadoriaConverter.convert(mercadoriaGateway.save(mercadoriaDataConverter.convert(mercadoria)));
            return ResponseEntity.ok().body(mercadoriaArmazenada);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<MercadoriaData> pedidos = new ArrayList<>();
        pedidos = mercadoriaGateway.getAll();
        return ResponseEntity.ok().body(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        Optional<MercadoriaData> mercadoriaData = mercadoriaGateway.getById(id);
        if(mercadoriaData.isEmpty())  {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(mercadoriaData);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Mercadoria mercadoria){
        try {
            return ResponseEntity.ok().body(mercadoriaGateway.update(mercadoriaDataConverter.convert(mercadoria)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        mercadoriaGateway.delete(id);
    }

}
