import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BancoTeste {

    private Banco banco;
    private Cliente cliente;
    private ContaBancaria conta;

    @Before
    public void setup() {
        banco = new Banco("Meu Banco");
        cliente = new Cliente("João", "12345");
        conta = new ContaBancaria("67890", "Maria", 1000.0, 500.0);
        cliente.adicionarConta(conta);
        banco.adicionarCliente(cliente);
    }

    @Test
    public void testAdicionarClienteAoBanco() {
        assertTrue(banco.getClientes().contains(cliente));
    }

    @Test
    public void testListarContasDoClienteNoBanco() {
        assertEquals(1, cliente.getContas().size());
        assertTrue(cliente.getContas().contains(conta));
    }

    @Test
    public void testRemoverClienteDoBanco() {
        banco.removerCliente(cliente);
        assertFalse(banco.getClientes().contains(cliente));
    }

    @Test
    public void testAprovarLimiteParaConta() {
        GerenteConta gerente = Mockito.mock(GerenteConta.class);
        Mockito.when(gerente.getNome()).thenReturn("Gerente João");

        conta.setLimite(1000.0);

        gerente.aprovarLimite(conta, 2000.0);

        assertEquals(1000.0, conta.getLimite(), 0.01);
    }

    @Test
    public void testBloquearEDesbloquearConta() {
        GerenteConta gerente = Mockito.mock(GerenteConta.class);
        Mockito.when(gerente.getNome()).thenReturn("Gerente Maria");

        assertFalse(conta.isBloqueada());

        gerente.bloquearConta(conta);

        assertFalse(conta.isBloqueada());

        gerente.desbloquearConta(conta);

        assertFalse(conta.isBloqueada());
    }
}
