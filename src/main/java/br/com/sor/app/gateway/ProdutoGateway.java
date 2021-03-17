package br.com.sor.app.gateway;

import br.com.sor.app.gateway.database.ProdutoData;

import java.util.List;
import java.util.Optional;

public interface ProdutoGateway {
    ProdutoData save(ProdutoData produto);
    List<ProdutoData> getAll();
    Optional<ProdutoData> getById(Integer id);
    ProdutoData update(ProdutoData produtoData)throws Exception;
}
