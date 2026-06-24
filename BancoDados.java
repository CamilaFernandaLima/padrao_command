import java.util.HashMap;
import java.util.Map;

/**
 * Receptor: contém as ações reais (inserir, deletar, listar) - os comandos concretos chamam os métodos daqui para fazer o trabalho.
 * 
 * Usa um HashMap<Integer, Pessoa> para armazenar as pessoas, onde a chave é o id e o valor é a Pessoa.
 */
public class BancoDados {

    private Map<Integer, Pessoa> pessoas = new HashMap<>();

    //Insere uma nova pessoa (rejeita se o id já existir)
    public void inserir(Pessoa p) {
        if (pessoas.containsKey(p.getId())) {
            System.out.println("[ERRO] Id " + p.getId() + " ja existe.");
            return;
        }
        pessoas.put(p.getId(), p);
        System.out.println("[OK] Pessoa inserida: " + p);
    }

    //Remove a pessoa pelo id (avisa se não encontrar)
    public void deletar(int id) {
        if (!pessoas.containsKey(id)) {
            System.out.println("[ERRO] Id " + id + " nao encontrado.");
            return;
        }
        Pessoa removida = pessoas.remove(id);
        System.out.println("[OK] Pessoa removida: " + removida);
    }

    //Retorna todas as pessoas cadastradas
    public Map<Integer, Pessoa> listarTodos() {
        return pessoas;
    }
}
