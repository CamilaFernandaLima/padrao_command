//COMMAND CONCRETO — remove uma pessoa do banco pelo id

public class DeletarPessoaCommand implements Command {

    private BancoDados db;

    public DeletarPessoaCommand(BancoDados db) {
        this.db = db;
    }

    @Override
    public Object execute(Object arg) {
        String[] args = (String[]) arg;
        
        // args[0] = id
        int id = Integer.parseInt(args[0]);
        db.deletar(id);
        return null;
    }
}
