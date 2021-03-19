package br.com.sor.app.controller.converter;

import br.com.sor.app.entity.Endereco;
import br.com.sor.app.gateway.database.EnderecoData;
import org.springframework.stereotype.Component;

@Component
public class EnderecoConverter {

    public Endereco convert(EnderecoData enderecoData){

        Endereco endereco = new Endereco();

        endereco.setCodigo(enderecoData.getId());
        endereco.setBairro(enderecoData.getBairro());
        endereco.setComplemento(enderecoData.getComplemento());
        endereco.setRua(enderecoData.getRua());
        endereco.setNumero(enderecoData.getNumero());

        return endereco;

    }

}
