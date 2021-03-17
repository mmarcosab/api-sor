package br.com.sor.app.entity;

public enum TipoPedido {

    SALAO(1, "salao"),
    BALCAO(1, "salao"),
    DELIVERY(1, "salao");

    private TipoPedido(int codigoTipoPedido, String descricaoTipoPedido){
        this.codigoTipoPedido = codigoTipoPedido;
        this.descricaoTipoPedido = descricaoTipoPedido;
    }

    private int codigoTipoPedido;
    private String descricaoTipoPedido;

}
