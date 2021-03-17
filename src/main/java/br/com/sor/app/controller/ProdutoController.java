package br.com.sor.app.controller;

import br.com.sor.app.entity.Produto;
import br.com.sor.app.gateway.ProdutoGateway;
import br.com.sor.app.gateway.database.ProdutoData;
import br.com.sor.app.gateway.database.converter.ProdutoDataConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@RestController
@RequestMapping("produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoGateway produtoGateway;
    private final ProdutoDataConverter produtoDataConverter;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Produto produto){
        log.info("Payload recebido: {}", produto);
        try {
            produtoGateway.save(produtoDataConverter.convert(produto));
            return ResponseEntity.ok().body(produto);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<ProdutoData> produtos = new ArrayList<>();
        produtos = produtoGateway.getAll();
        return ResponseEntity.ok().body(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        Optional<ProdutoData> produtoData = produtoGateway.getById(id);
        if(produtoData.isEmpty())  {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(produtoData);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Produto produto){
        try {
            return ResponseEntity.ok().body(produtoGateway.update(produtoDataConverter.convert(produto)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
