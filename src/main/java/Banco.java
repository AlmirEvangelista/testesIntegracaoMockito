import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Cliente> clientes;

    public Banco(String nome) {
        this.nome = nome;
        this.clientes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente " + cliente.getNome() + " adicionado ao banco " + nome);
    }

    public void listarClientes() {
        System.out.println("Clientes do banco " + nome + ":");
        for (Cliente cliente : clientes) {
            System.out.println("Nome do cliente: " + cliente.getNome());
        }
    }

    public void removerCliente(Cliente cliente) {
        if (clientes.contains(cliente)) {
            clientes.remove(cliente);
            System.out.println("Cliente " + cliente.getNome() + " removido do banco " + nome);
        } else {
            System.out.println("O cliente não pertence a este banco.");
        }
    }
}
