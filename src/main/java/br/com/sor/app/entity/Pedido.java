package br.com.sor.app.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    private int codigo;
    private int tipoPedido;
    private int numeroMesa;
    private List<Produto> produtos;
    private BigDecimal total;

}
