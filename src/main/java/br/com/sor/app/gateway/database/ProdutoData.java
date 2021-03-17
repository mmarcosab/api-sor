package br.com.sor.app.gateway.database;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produto")
public class ProdutoData {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco")
    private BigDecimal preco;

    @Column(name = "img")
    private String caminhoImagem;
}
