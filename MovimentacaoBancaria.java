import java.util.Scanner;

public class MovimentacaoBancaria {
    private int numeroConta;
    private double saldo;

    public MovimentacaoBancaria(int numeroConta, double saldo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public String depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            return "Depósito de R$" + valor + " realizado. Novo saldo: R$" + this.saldo;
        } else {
            return "Valor de depósito inválido.";
        }
    }

    public String sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            return "Saque de R$" + valor + " realizado. Novo saldo: R$" + this.saldo;
        } else {
            return "Saque indisponível ou valor inválido.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();

        System.out.print("Digite o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        MovimentacaoBancaria conta = new MovimentacaoBancaria(numeroConta, saldoInicial);

        System.out.print("Digite o valor a ser depositado: ");
        double valorDeposito = scanner.nextDouble();
        System.out.println(conta.depositar(valorDeposito));

        System.out.print("Digite o valor a ser sacado: ");
        double valorSaque = scanner.nextDouble();
        System.out.println(conta.sacar(valorSaque));

        scanner.close();
    }
}
