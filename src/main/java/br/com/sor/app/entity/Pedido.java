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
    private List<Produto> produtos;
    private BigDecimal total = BigDecimal.ZERO;

    public BigDecimal getTotal(){
        BigDecimal x = null;
        for(Produto p : produtos){
            total.add(p.getPreco());
        }
        return total;
    }

}
