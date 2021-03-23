package br.com.sor.app.controller;


import br.com.sor.app.controller.converter.PedidoConverter;
import br.com.sor.app.gateway.PedidoGateway;
import br.com.sor.app.gateway.database.converter.PedidoDataConverter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


//@RunWith(JUnitPlatform.class)
public class ControllerTests {

    private PedidoController pedidoController;
    private PedidoGateway pedidoGateway;
    private PedidoDataConverter pedidoDataConverter;
    private PedidoConverter pedidoConverter;

    @DisplayName("Init da classe de testes das controllers sendo executado")
    @BeforeAll
    public void init(){
        pedidoGateway = Mockito.mock(PedidoGateway.class);
        pedidoDataConverter = Mockito.mock(PedidoDataConverter.class);
        pedidoConverter = Mockito.mock(PedidoConverter.class);
        pedidoController = new PedidoController(pedidoGateway, pedidoDataConverter, pedidoConverter);
    }

    @DisplayName("Init da classe de testes das controllers sendo executado")
    @Test
    public void testDelete(){
        pedidoController.delete(1);
    }


}
