package br.com.sor.app.service;

import br.com.sor.app.gateway.PedidoGateway;
import br.com.sor.app.gateway.database.PedidoSalaoData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Slf4j
@Component
@RequiredArgsConstructor
public class MercadoriaService {

    private final PedidoGateway pedidoGateway;

    public int getNumber(int number){
        Optional<PedidoSalaoData> pedidoSalaoData = pedidoGateway.getPedidoSalaoByNumeroMesa(number);
        if (pedidoSalaoData.isEmpty()){
            log.info("Não existe ..");
            return 1;
        } else {
            log.info("Existe e devo fazer outra coisa .. ");
            return 2;
        }
    }

}
