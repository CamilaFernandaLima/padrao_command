public class Teste {
    public static void main(String[] args) {
        BancoPessoas app = new BancoPessoas();

        System.out.println("--- new ---");
        app.service("new", new String[]{"1", "Ana"});
        app.service("new", new String[]{"2", "Bruno"});
        app.service("new", new String[]{"3", "Carla"});

        System.out.println("\n--- all ---");
        app.service("all", new String[]{});

        System.out.println("\n--- get existente ---");
        app.service("get", new String[]{"1"});

        System.out.println("\n--- get inexistente ---");
        app.service("get", new String[]{"99"});

        System.out.println("\n--- delete ---");
        app.service("delete", new String[]{"2"});

        System.out.println("\n--- all apos delete ---");
        app.service("all", new String[]{});

        System.out.println("\n--- id duplicado ---");
        app.service("new", new String[]{"1", "Teste"});

        System.out.println("\n--- comando invalido ---");
        app.service("xpto", new String[]{});
    }
}