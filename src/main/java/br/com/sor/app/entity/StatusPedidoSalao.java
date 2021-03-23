package br.com.sor.app.entity;

public enum StatusPedidoSalao {

    ABERTO(0, "fechado"),
    FECHADO(1, "aberto"),
    PAGO(2, "pago");

    private int codigo;
    private String descricao;

    private StatusPedidoSalao(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

}
