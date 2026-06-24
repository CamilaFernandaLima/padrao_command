//COMMAND CONCRETO — busca uma pessoa pelo id

public class BuscarPessoaCommand implements Command {

    private BancoDados db;

    public BuscarPessoaCommand(BancoDados db) {
        this.db = db;
    }

    @Override
    public Object execute(Object arg) {
        String[] args = (String[]) arg;
        int id = Integer.parseInt(args[0]);
        Pessoa p = db.buscar(id);
        if (p == null) {
            System.out.println("[ERRO] Id " + id + " nao encontrado.");
        } else {
            System.out.println("[OK] " + p);
        }
        return p;
    }
}