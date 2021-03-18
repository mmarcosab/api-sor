package br.com.sor.app.entity;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private int codigo;
    private String rua;
    private String numero;
    private String bairro;
    private String complemento;

}