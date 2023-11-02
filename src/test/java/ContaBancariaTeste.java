import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ContaBancariaTeste {

    private ContaBancaria conta;
    private Banco banco;
    private Cliente cliente;

    @Before
    public void setup() {
        conta = new ContaBancaria("12345", "João", 1000.0, 500.0);
        banco = new Banco("Meu Banco");
        cliente = new Cliente("Maria", "67890");
        banco.adicionarCliente(cliente);
        cliente.adicionarConta(conta);
    }

    @Test
    public void testDeposito() {
        conta.depositar(500.0);
        assertEquals(1500.0, conta.getSaldo(), 0.01);
    }

    @Test
    public void testSaque() {
        conta.sacar(300.0);
        assertEquals(700.0, conta.getSaldo(), 0.01);
    }

    @Test
    public void testTransferencia() {
        ContaBancaria destino = new ContaBancaria("54321", "Carlos", 2000.0, 1000.0);
        cliente.adicionarConta(destino);

        // Simulando o comportamento do método desbloquearConta
        GerenteConta gerente = Mockito.mock(GerenteConta.class);
        Mockito.doNothing().when(gerente).desbloquearConta(destino);

        conta.transferir(destino, 500.0);

        assertEquals(500.0, conta.getSaldo(), 0.01);
        assertEquals(2500.0, destino.getSaldo(), 0.01);
    }


    @Test
    public void testDefinirLimite() {
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
