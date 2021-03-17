package br.com.sor.app.entity;

public enum TipoQuantidade {

    UNIDADE(1, "unidade"),
    KILO(2, "kg"),
    LITROS(3, "litros");

    private TipoQuantidade(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    private int codigo;
    private String descricao;

}
