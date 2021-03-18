package br.com.sor.app.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDelivery {

    private int codigo;
    private List<Produto> produtos;
    private BigDecimal total;
    private Cliente cliente;

}