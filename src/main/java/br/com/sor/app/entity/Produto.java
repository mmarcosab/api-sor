package br.com.sor.app.entity;

import lombok.*;
import java.math.BigDecimal;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    private int codigo;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private String caminhoImagem;

}
