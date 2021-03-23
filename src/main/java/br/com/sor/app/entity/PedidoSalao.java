package br.com.sor.app.entity;

import lombok.*;


@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoSalao extends Pedido {

    private int numeroMesa;
    private int status; // 0 fechado 1 aberto

}
