package br.com.sor.app.entity;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private int codigo;
    private String nome;
    private String telefone;
    private Endereco endereco;

}
