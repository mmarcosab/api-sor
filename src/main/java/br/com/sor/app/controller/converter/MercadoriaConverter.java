package br.com.sor.app.controller.converter;

import br.com.sor.app.entity.Mercadoria;
import br.com.sor.app.gateway.database.MercadoriaData;
import org.springframework.stereotype.Component;


@Component
public class MercadoriaConverter {

    public Mercadoria convert(MercadoriaData mercadoriaData){

        Mercadoria mercadoria = new Mercadoria();

        mercadoria.setCodigo(mercadoriaData.getId());
        mercadoria.setNome(mercadoriaData.getNome());
        mercadoria.setQuantidade(mercadoriaData.getQuantidade());
        mercadoria.setTipoQuantidade(mercadoriaData.getTipoQuantidade());

        return mercadoria;

    }

}
