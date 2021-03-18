package br.com.sor.app.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoSalao {

    private int codigo;
    private int numeroMesa;
    private List<Produto> produtos;
    private BigDecimal total;

}
