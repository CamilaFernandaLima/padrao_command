import java.util.HashMap;
import java.util.Map;

/**
 * SERVER — ponto de entrada da aplicação e o Executor
 *
 * Dois HashMaps:
 *   - db (BancoDados): armazena as pessoas
 *   - cmds: mapeia strings de comando para objetos Command
 *
 * O método service() busca o comando no HashMap e chama execute(),
 * sem precisar saber qual comando concreto está sendo executado.
 * 
 * Uso: java BancoPessoas <comando> [<args>]
 *   new <id> <nome>   — cadastra uma pessoa
 *   delete <id>       — remove uma pessoa
 *   all               — lista todas as pessoas
 *   get <id>          — busca uma pessoa pelo id
 */
public class BancoPessoas {

    private BancoDados db = new BancoDados();

    /*
     * HashMap de comandos:
     * - A chave é a string digitada pelo usuário ("new", "delete", "all").
     * - O valor é o objeto Command correspondente
     */
    private Map<String, Command> cmds = new HashMap<>();

    public BancoPessoas() {
        initCommands();
    }

    //Registra todos os comandos disponíveis no HashMap
    private void initCommands() {
        cmds.put("new", new NovaPessoaCommand(db));
        cmds.put("delete", new DeletarPessoaCommand(db));
        cmds.put("all", new ListarTodosCommand(db));
        cmds.put("get", new BuscarPessoaCommand(db));
    }

    /**
     * SERVIÇO — recebe o comando e os argumentos, e executa o comando correspondente.
     * (se o comando não existir, exibe uma mensagem de erro)
     */
    public void service(String cmd, Object data) {
        Command c = (Command) cmds.get(cmd);
        if (c == null) {
            System.out.println("[ERRO] Comando desconhecido: " + cmd);
            System.out.println("Comandos disponiveis: new <id> <nome> | delete <id> | all");
            return;
        }
        Object result = c.execute(data);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso: java BancoPessoas <comando> [<args>]");
            System.out.println("Comandos: new <id> <nome> | delete <id> | all");
            return;
        }

        BancoPessoas app = new BancoPessoas();

        /*
         * args[0]  = o comando ("new", "delete", "all")
         * args[1+] = os argumentos do comando
         */
        String cmd = args[0];
        String[] cmdArgs = new String[args.length - 1];
        System.arraycopy(args, 1, cmdArgs, 0, cmdArgs.length);

        app.service(cmd, cmdArgs);
    }
}