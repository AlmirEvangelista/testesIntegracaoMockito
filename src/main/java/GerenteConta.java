public class GerenteConta {
    private String nome;
    private String matricula;

    public GerenteConta(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    ContaBancaria conta = new ContaBancaria("12345", "João", 1000.0, 500.0);
    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void aprovarLimite(ContaBancaria conta, double novoLimite) {
        conta.setLimite(novoLimite);
        System.out.println("Novo limite aprovado para a conta " + conta.getNumeroConta() + " pelo gerente " + nome);
    }

    public void bloquearConta(ContaBancaria conta) {
        conta.setBloqueada(true);
        System.out.println("A conta " + conta.getNumeroConta() + " foi bloqueada pelo gerente " + nome);
    }

    public void desbloquearConta(ContaBancaria conta) {
        conta.setBloqueada(false);
        System.out.println("A conta " + conta.getNumeroConta() + " foi desbloqueada pelo gerente " + nome);
    }

    public void rejeitarLimite(ContaBancaria conta) {
        // Lógica de rejeição de limite, se necessário
    }
}
