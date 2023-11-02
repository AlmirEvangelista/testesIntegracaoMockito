import java.util.Date;

public class Transacao {
    private ContaBancaria origem;
    private ContaBancaria destino;
    private double valor;
    private Date data;

    public Transacao(ContaBancaria origem, ContaBancaria destino, double valor) {
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
        this.data = new Date();
    }

    public ContaBancaria getOrigem() {
        return origem;
    }

    public ContaBancaria getDestino() {
        return destino;
    }

    public double getValor() {
        return valor;
    }

    public Date getData() {
        return data;
    }

    public void registrarTransacao() {
        origem.sacar(valor);
        destino.depositar(valor);
        System.out.println("Transação de R$" + valor + " realizada com sucesso de " + origem.getTitular() + " para " + destino.getTitular() + " em " + data);
    }
}

