package br.com.sor.app.gateway.impl;

import br.com.sor.app.gateway.MercadoriaGateway;
import br.com.sor.app.gateway.database.MercadoriaData;
import br.com.sor.app.gateway.database.repository.MercadoriaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;


@Slf4j
@Component
@RequiredArgsConstructor
public class MercadoriaGatewayImpl implements MercadoriaGateway {

    private final MercadoriaRepository mercadoriaRepository;

    @Override
    public MercadoriaData save(MercadoriaData mercadoriaData){
        log.debug("Armazenando mercadoria: {}", mercadoriaData);
        return mercadoriaRepository.save(mercadoriaData);
    }

    @Override
    public List<MercadoriaData> getAll(){
        log.debug("Buscando as mercadorias cadastradas");
        return mercadoriaRepository.findAll();
    }

    @Override
    public Optional<MercadoriaData> getById(Integer id){
        log.debug("Buscando mercadoria por id {}", id);
        return mercadoriaRepository.findById(id);
    }

    @Override
    public MercadoriaData update(MercadoriaData mercadoriaData)throws Exception {
        log.debug("Buscando produto por id {}", mercadoriaData.getId());
        Optional<MercadoriaData> mercadoriaDataExistente = mercadoriaRepository.findById(mercadoriaData.getId());
        if(mercadoriaDataExistente == null){
            throw new Exception("Produto nao existe: " +  mercadoriaData.toString());
        } else {
            mercadoriaDataExistente.get().setNome(mercadoriaData.getNome());
            mercadoriaDataExistente.get().setQuantidade(mercadoriaData.getQuantidade());
            mercadoriaDataExistente.get().setTipoQuantidade(mercadoriaData.getTipoQuantidade());
            return mercadoriaRepository.save(mercadoriaData);
        }
    }

    @Override
    public void delete(Integer id){
        mercadoriaRepository.deleteById(id);
    }


}
