import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.Date;

public class TransacaoTeste {

    private Transacao transacao;
    private ContaBancaria contaOrigem;
    private ContaBancaria contaDestino;

    @Before
    public void setup() {
        contaOrigem = Mockito.mock(ContaBancaria.class);
        contaDestino = Mockito.mock(ContaBancaria.class);
        transacao = new Transacao(contaOrigem, contaDestino, 500.0);
    }

    @Test
    public void testRegistrarTransacao() {
        // Simule o método void sacar
        Mockito.doNothing().when(contaOrigem).sacar(500.0);

        // Simule o método void depositar
        Mockito.doNothing().when(contaDestino).depositar(500.0);

        // Realize a transação
        transacao.registrarTransacao();

        // Verifique se o método sacar foi chamado na conta origem
        Mockito.verify(contaOrigem).sacar(500.0);

        // Verifique se o método depositar foi chamado na conta destino
        Mockito.verify(contaDestino).depositar(500.0);
    }

    @Test
    public void testGetOrigem() {
        assertEquals(contaOrigem, transacao.getOrigem());
    }

    @Test
    public void testGetDestino() {
        assertEquals(contaDestino, transacao.getDestino());
    }

    @Test
    public void testGetValor() {
        assertEquals(500.0, transacao.getValor(), 0.01);
    }

    @Test
    public void testGetData() {
        Date dataAtual = new Date();
        assertEquals(dataAtual.getTime(), transacao.getData().getTime(), 1000); // Verifica com uma margem de erro de 1000ms (1 segundo)
    }
}
