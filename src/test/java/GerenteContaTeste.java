import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class GerenteContaTeste {

    private GerenteConta gerente;
    private ContaBancaria conta;

    @Before
    public void setup() {
        gerente = new GerenteConta("Gerente João", "123");
        conta = Mockito.mock(ContaBancaria.class);
    }

    @Test
    public void testAprovarLimite() {
        gerente.aprovarLimite(conta, 2000.0);
        Mockito.verify(conta).setLimite(2000.0);
    }

    @Test
    public void testBloquearConta() {
        gerente.bloquearConta(conta);
        Mockito.verify(conta).setBloqueada(true);
    }

    @Test
    public void testDesbloquearConta() {
        gerente.desbloquearConta(conta);
        Mockito.verify(conta).setBloqueada(false);
    }

    @Test
    public void testRejeitarLimite() {
        // Teste de rejeição de limite (pode ser implementado conforme necessário)
        gerente.rejeitarLimite(conta);
        // Aqui você pode verificar alguma ação específica relacionada à rejeição, se necessário
    }

    @Test
    public void testGetNome() {
        assertEquals("Gerente João", gerente.getNome());
    }
}
