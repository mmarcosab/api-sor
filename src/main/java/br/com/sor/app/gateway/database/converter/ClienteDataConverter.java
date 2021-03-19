package br.com.sor.app.gateway.database.converter;


import br.com.sor.app.entity.Cliente;
import br.com.sor.app.gateway.database.ClienteData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ClienteDataConverter {

    private final EnderecoDataConverter enderecoDataConverter;

    public ClienteData convert(Cliente cliente) {

        ClienteData clienteData = new ClienteData();

        if(cliente.getCodigo() > 0){
            clienteData.setId(cliente.getCodigo());
        }
        clienteData.setNome(cliente.getNome());
        clienteData.setEndereco(enderecoDataConverter.convert(cliente.getEndereco()));
        clienteData.setTelefone(cliente.getTelefone());

        return clienteData;

    }

}
