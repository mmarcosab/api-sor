package br.com.sor.app.gateway.database.converter;

import br.com.sor.app.entity.Mercadoria;
import br.com.sor.app.gateway.database.MercadoriaData;
import org.springframework.stereotype.Component;


@Component
public class MercadoriaDataConverter {

    public MercadoriaData convert(Mercadoria mercadoria){

        MercadoriaData mercadoriaData = new MercadoriaData();

        if(mercadoria.getCodigo() > 0) {
            mercadoriaData.setId(mercadoria.getCodigo());
        }
        mercadoriaData.setNome(mercadoria.getNome());
        mercadoriaData.setQuantidade(mercadoria.getQuantidade());
        mercadoriaData.setTipoQuantidade(mercadoria.getTipoQuantidade());

        return mercadoriaData;

    }

}
