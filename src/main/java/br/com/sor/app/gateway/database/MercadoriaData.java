package br.com.sor.app.gateway.database;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;


@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mercadoria")
public class MercadoriaData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "quantidade")
    private BigDecimal quantidade;

    @Column(name = "tipo_quantidade")
    private int tipoQuantidade;

}
