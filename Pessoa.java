//Representa um registro no banco de dados

public class Pessoa {
    private int id;
    private String nome;

    public Pessoa(int id, String nome) {
        this.id   = id;
        this.nome = nome;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }

    @Override
    public String toString() {
        return "Pessoa{id=" + id + ", nome='" + nome + "'}";
    }
}