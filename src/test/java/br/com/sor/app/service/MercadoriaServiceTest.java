package br.com.sor.app.service;

import br.com.sor.app.gateway.PedidoGateway;
import br.com.sor.app.gateway.database.PedidoSalaoData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class MercadoriaServiceTest {

    private MercadoriaService mercadoriaService;
    private PedidoGateway pedidoGateway;

    @BeforeEach
    public void init(){
        pedidoGateway = mock(PedidoGateway.class);
        mercadoriaService = new MercadoriaService(pedidoGateway);
    }

    @Test
    public void testGetNumber1(){
        int retorno = mercadoriaService.getNumber(10);
        Assertions.assertEquals(1, retorno);
    }

    @Test
    public void testGetNumber2(){
        PedidoSalaoData pedidoSalaoData = mock(PedidoSalaoData.class);
        when(pedidoGateway.getPedidoSalaoByNumeroMesa(any())).thenReturn(Optional.of(pedidoSalaoData));
        int retorno = mercadoriaService.getNumber(10);
        Assertions.assertEquals(2, retorno);
    }

}
