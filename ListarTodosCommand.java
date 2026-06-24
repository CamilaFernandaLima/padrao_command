import java.util.Map;

// COMANDO CONCRETO — lista todas as pessoas cadastradas.
public class ListarTodosCommand implements Command {

    private BancoDados db;

    public ListarTodosCommand(BancoDados db) {
        this.db = db;
    }

    @Override
    public Object execute(Object arg) {
        Map<Integer, ?> todos = db.listarTodos();
        if (todos.isEmpty()) {
            System.out.println("[OK] Banco vazio.");
        } else {
            System.out.println("[OK] Pessoas cadastradas:");
            for (Object p : todos.values()) {
                System.out.println("  " + p);
            }
        }
        return todos;
    }
}