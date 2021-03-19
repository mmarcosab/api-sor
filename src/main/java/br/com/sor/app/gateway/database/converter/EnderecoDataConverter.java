package br.com.sor.app.gateway.database.converter;

import br.com.sor.app.entity.Endereco;
import br.com.sor.app.gateway.database.EnderecoData;
import org.springframework.stereotype.Component;

@Component
public class EnderecoDataConverter {

    public EnderecoData convert(Endereco endereco){

        EnderecoData enderecoData = new EnderecoData();

        if(endereco.getCodigo() > 0) {
            enderecoData.setId(endereco.getCodigo());
        }
        enderecoData.setBairro(endereco.getBairro());
        enderecoData.setComplemento(endereco.getComplemento());
        enderecoData.setRua(endereco.getRua());
        enderecoData.setNumero(endereco.getNumero());

        return enderecoData;

    }

}
