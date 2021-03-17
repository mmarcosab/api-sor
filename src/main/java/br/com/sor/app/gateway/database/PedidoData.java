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
@Table(name = "pedido")
public class PedidoData {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "item")
    private List<ProdutoData> produtos;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "tipo_pedido")
    private int tipoPedido;

}
