package br.com.sor.app.gateway;

import br.com.sor.app.gateway.database.MercadoriaData;
import java.util.List;
import java.util.Optional;


public interface MercadoriaGateway {
    MercadoriaData save(MercadoriaData mercadoriaData);
    List<MercadoriaData> getAll();
    Optional<MercadoriaData> getById(Integer id);
    MercadoriaData update(MercadoriaData mercadoriaData)throws Exception;
    void delete(Integer id);
}
