/**
 * COMMAND CONCRETO — cria uma nova pessoa no banco
 *
 * Recebe o BancoDados no construtor (o Receptor)
 * - execute() recebe os args como Object, faz o cast para String[], extrai id e nome, e chama db.inserir().
 */
public class NovaPessoaCommand implements Command {

    private BancoDados db;

    public NovaPessoaCommand(BancoDados db) {
        this.db = db;
    }

    @Override
    public Object execute(Object arg) {
        String[] args = (String[]) arg;
        
        // args[0] = id, args[1] = nome
        int id = Integer.parseInt(args[0]);
        String nome = args[1];
        db.inserir(new Pessoa(id, nome));
        return null;
    }
}