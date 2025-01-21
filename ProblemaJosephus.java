import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Pessoa {
    private int numero;
    private String nome;
    private String telefone;
    private String endereco;
    private String cpf;

    public Pessoa(int numero, String nome, String telefone, String endereco, String cpf) {
        this.numero = numero;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return String.format(
            "Número: %d, Nome: %s, Telefone: %s, Endereço: %s, CPF: %s",
            numero, nome, telefone, endereco, cpf
        );
    }
}

public class ProblemaJosephus {
    public static void main(String[] args) {
        List<Pessoa> roda = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= 20; i++) {
            roda.add(new Pessoa(i, "Pessoa " + i, "Telefone " + i, "Endereço " + i, "CPF " + i));
        }

        System.out.println("Roda inicial:");
        imprimirRoda(roda);

        int indiceAtual = 0;

        while (roda.size() > 1) {
            int m = random.nextInt(roda.size()) + 1;
            indiceAtual = (indiceAtual + m - 1) % roda.size();
            Pessoa eliminada = roda.remove(indiceAtual);

            System.out.println("\nEliminada:");
            System.out.println(eliminada);
            System.out.println("\nRoda atual:");
            imprimirRoda(roda);
        }

        System.out.println("\nSobrevivente:");
        System.out.println(roda.get(0));
    }

    private static void imprimirRoda(List<Pessoa> roda) {
        System.out.println("=== PESSOAS NA RODA ===");
        for (Pessoa pessoa : roda) {
            System.out.println(pessoa);
        }
        System.out.println("========================");
    }
}