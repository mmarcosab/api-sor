package br.com.sor.app.controller.converter;

import br.com.sor.app.entity.Produto;
import br.com.sor.app.gateway.database.ProdutoData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoConverter {

    public Produto convert(ProdutoData produtoData){

        Produto produto = new Produto();

        produto.setCodigo(produtoData.getId());
        produto.setNome(produtoData.getNome());
        produto.setDescricao(produtoData.getDescricao());
        produto.setPreco(produtoData.getPreco());
        produto.setCaminhoImagem(produtoData.getCaminhoImagem());

        return produto;

    }

    public List<Produto> convert(List<ProdutoData> produtosData){

        List<Produto> produtos = new ArrayList<>();

        for(ProdutoData p : produtosData) {

            Produto produto = new Produto();
            produto.setCodigo(p.getId());
            produto.setNome(p.getNome());
            produto.setDescricao(p.getDescricao());
            produto.setPreco(p.getPreco());
            produto.setCaminhoImagem(p.getCaminhoImagem());
            produtos.add(produto);

        }
        return produtos;
    }

}
