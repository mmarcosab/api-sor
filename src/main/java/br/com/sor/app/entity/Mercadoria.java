package br.com.sor.app.entity;

import lombok.*;
import java.math.BigDecimal;


@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mercadoria {

    private int codigo;
    private String nome;
    private BigDecimal quantidade;
    private int tipoQuantidade;

}
