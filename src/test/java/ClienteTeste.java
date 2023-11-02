import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ClienteTeste {

    private Cliente cliente;
    private ContaBancaria conta;

    @Before
    public void setup() {
        cliente = new Cliente("João", "12345");
        conta = Mockito.mock(ContaBancaria.class);
        cliente.adicionarConta(conta);
    }

    @Test
    public void testAdicionarContaAoCliente() {
        assertTrue(cliente.getContas().contains(conta));
    }

    @Test
    public void testListarContasDoCliente() {
        assertEquals(1, cliente.getContas().size());
        assertTrue(cliente.getContas().contains(conta));
    }

    @Test
    public void testRemoverContaDoCliente() {
        cliente.removerConta(conta);
        assertFalse(cliente.getContas().contains(conta));
    }

    @Test
    public void testDepositarNaContaDoCliente() {
        Mockito.when(conta.getSaldo()).thenReturn(1000.0);
        cliente.depositarEmConta(conta, 500.0);
        Mockito.verify(conta).depositar(500.0);
        assertEquals(1000.0, cliente.getSaldoTotal(), 0.01);
    }

    @Test
    public void testSacarDaContaDoCliente() {
        Mockito.when(conta.getSaldo()).thenReturn(1000.0);
        cliente.sacarDeConta(conta, 300.0);
        Mockito.verify(conta).sacar(300.0);
        assertEquals(1000.0, cliente.getSaldoTotal(), 0.01);
    }
}
