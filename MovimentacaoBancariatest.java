import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MovimentacaoBancariaTest {
    private MovimentacaoBancaria movimentacaoBancaria;

    @BeforeEach
    public void setUp() {
        movimentacaoBancaria = Mockito.spy(new MovimentacaoBancaria(12345, 1000.0));
    }

    @Test
    public void testDepositar() {
        when(movimentacaoBancaria.depositar(500.0)).thenReturn("Depósito de R$500.0 realizado. Novo saldo: R$1500.0");
        assertEquals("Depósito de R$500.0 realizado. Novo saldo: R$1500.0", movimentacaoBancaria.depositar(500.0));
    }

    @Test
    public void testSaqueBemSucedido() {
        when(movimentacaoBancaria.sacar(200.0)).thenReturn("Saque de R$200.0 realizado. Novo saldo: R$800.0");
        assertEquals("Saque de R$200.0 realizado. Novo saldo: R$800.0", movimentacaoBancaria.sacar(200.0));
    }

    @Test
    public void testSaqueSemSaldoSuficiente() {
        when(movimentacaoBancaria.sacar(1500.0)).thenReturn("Saque indisponível ou valor inválido.");
        assertEquals("Saque indisponível ou valor inválido.", movimentacaoBancaria.sacar(1500.0));
    }

    @Test
    public void testSaqueComValorInvalido() {
        when(movimentacaoBancaria.sacar(-200.0)).thenReturn("Saque indisponível ou valor inválido.");
        assertEquals("Saque indisponível ou valor inválido.", movimentacaoBancaria.sacar(-200.0));
    }
}
