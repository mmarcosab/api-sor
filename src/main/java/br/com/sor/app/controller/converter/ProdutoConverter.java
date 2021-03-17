package br.com.sor.app.controller.converter;

import br.com.sor.app.entity.Produto;
import br.com.sor.app.gateway.database.ProdutoData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoConverter {

    public ProdutoData convert(Produto produto){

        ProdutoData produtoData = new ProdutoData();

        produtoData.setNome(produto.getNome());
        produtoData.setDescricao(produto.getDescricao());
        produtoData.setPreco(produto.getPreco());
        produtoData.setCaminhoImagem(produto.getCaminhoImagem());

        return produtoData;

    }

    public List<ProdutoData> convert(List<Produto> produtos){
        List<ProdutoData> produtosData = new ArrayList<>();
        for(Produto p : produtos) {
            ProdutoData produtoData = new ProdutoData();
            produtoData.setNome(p.getNome());
            produtoData.setDescricao(p.getDescricao());
            produtoData.setPreco(p.getPreco());
            produtoData.setCaminhoImagem(p.getCaminhoImagem());
            produtosData.add(produtoData);
        }
        return produtosData;
    }

}
