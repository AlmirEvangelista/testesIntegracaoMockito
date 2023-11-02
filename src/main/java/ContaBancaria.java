public class ContaBancaria {
    private String numeroConta;
    private String titular;
    private double saldo;
    private double limite;
    private boolean bloqueada;

    public ContaBancaria(String numeroConta, String titular, double saldo, double limite) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setLimite(double novoLimite) {
        this.limite = novoLimite;
    }

    public double getLimite() {
        return limite;
    }

    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para saque.");
        }
    }

    public void transferir(ContaBancaria destino, double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            destino.depositar(valor);
            System.out.println("Transferência de R$" + valor + " realizada com sucesso para a conta de " + destino.getTitular());
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para transferência.");
        }
    }


}
