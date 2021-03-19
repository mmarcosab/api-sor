package br.com.sor.app.controller.converter;

import br.com.sor.app.entity.Cliente;
import br.com.sor.app.gateway.database.ClienteData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ClienteConverter {

    private final EnderecoConverter enderecoConverter;

    public Cliente convert(ClienteData clienteData) {

        Cliente cliente = new Cliente();

        cliente.setCodigo(clienteData.getId());
        cliente.setNome(clienteData.getNome());
        cliente.setEndereco(enderecoConverter.convert(clienteData.getEndereco()));
        cliente.setTelefone(clienteData.getTelefone());

        return cliente;

    }

}
