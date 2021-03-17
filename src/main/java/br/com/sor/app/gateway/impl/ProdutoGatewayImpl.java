package br.com.sor.app.gateway.impl;

import br.com.sor.app.gateway.ProdutoGateway;
import br.com.sor.app.gateway.database.ProdutoData;
import br.com.sor.app.gateway.database.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProdutoGatewayImpl implements ProdutoGateway {

    private final ProdutoRepository produtoRepository;

    public ProdutoData save(ProdutoData produtoData){
        log.debug("Armazenando produto: {}", produtoData);
        return produtoRepository.save(produtoData);
    }

    public List<ProdutoData> getAll(){
        log.debug("Buscando todos os produtos cadastrados");
        return produtoRepository.findAll();
    }

    public Optional<ProdutoData> getById(Integer id){
        log.debug("Buscando produto por id {}", id);
        return produtoRepository.findById(id);
    }

    public ProdutoData update(ProdutoData produtoData)throws Exception {
        log.debug("Buscando produto por id {}", produtoData.getId());
        Optional<ProdutoData> produtoDataExistente = produtoRepository.findById(produtoData.getId());
        if(produtoDataExistente == null){
            throw new Exception("Produto nao existe: " +  produtoData.toString());
        } else {
            produtoDataExistente.get().setNome(produtoData.getNome());
            produtoDataExistente.get().setDescricao(produtoData.getDescricao());
            produtoDataExistente.get().setPreco(produtoData.getPreco());
            return produtoRepository.save(produtoDataExistente.get());
        }
    }

}
