package br.com.sor.app.gateway.database;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido_balcao")
public class PedidoBalcaoData {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "nome_cliente")
    private String nomeCliente;

    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "item")
    private List<ProdutoData> produtos;

    @Column(name = "total")
    private BigDecimal total;

}
