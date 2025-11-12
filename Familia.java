package trabalho;

import java.util.ArrayList;
import java.util.List;

public class Familia extends Pessoa {
    private List<Morador> moradores;

    public Familia(String nome, String cpf) {
        super(nome, cpf);
        this.moradores = new ArrayList<>();
    }

    public void adicionarMorador(Morador morador) {
        moradores.add(morador);
        System.out.println(morador.getNome() + " adicionado à família " + nome + "!");
    }

    public void listarMoradores() {
        System.out.println("\n--- Moradores da Família " + nome + " ---");
        if (moradores.isEmpty()) {
            System.out.println("Nenhum morador cadastrado.");
        } else {
            for (Morador m : moradores) {
                System.out.println(m);
            }
        }
    }

    public List<Morador> getMoradores() {
        return moradores;
    }
}