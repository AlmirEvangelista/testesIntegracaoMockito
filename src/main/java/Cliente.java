import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private List<ContaBancaria> contas;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public List<ContaBancaria> getContas() {
        return contas;
    }

    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
        System.out.println("Conta " + conta.getNumeroConta() + " adicionada para o cliente " + nome);
    }

    public void listarContas() {
        System.out.println("Contas do cliente " + nome + ":");
        for (ContaBancaria conta : contas) {
            System.out.println("Número da conta: " + conta.getNumeroConta());
        }
    }

    public void removerConta(ContaBancaria conta) {
        if (contas.contains(conta)) {
            contas.remove(conta);
            System.out.println("Conta " + conta.getNumeroConta() + " removida do cliente " + nome);
        } else {
            System.out.println("A conta não pertence a este cliente.");
        }
    }

    public double getSaldoTotal() {
        double saldoTotal = 0.0;
        for (ContaBancaria conta : contas) {
            saldoTotal += conta.getSaldo();
        }
        return saldoTotal;
    }

    public void depositarEmConta(ContaBancaria conta, double valor) {
        conta.depositar(valor);
    }

    public void sacarDeConta(ContaBancaria conta, double valor) {
        conta.sacar(valor);
    }
}
