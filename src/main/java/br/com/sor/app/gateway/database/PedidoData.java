package br.com.sor.app.gateway.database;

import br.com.sor.app.entity.Produto;
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
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "item")
    private List<Produto> produtos;

    @Column(name = "total")
    private BigDecimal total;

}
