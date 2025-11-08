import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.Arrays;

public class UsuarioOperations {

    private MongoCollection<Document> docsUsuario;

    public UsuarioOperations(MongoDBConnection connection) {
        this.docsUsuario = connection.getDatabase().getCollection("usuarios");
    }

    public void initUsuario() {
        Usuario user1 = new Usuario("Alice", 25);
        Usuario user2 = new Usuario("Bob", 30);
        Usuario user3 = new Usuario("Charlie", 35);

        docsUsuario.insertMany(Arrays.asList(user1.toDocument(), user2.toDocument(), user3.toDocument()));
        System.out.println("[INIT] Usuários inseridos");
    }

    public void createUsuario(Usuario usuario) {
        docsUsuario.insertOne(usuario.toDocument());
        System.out.println("[CREATE] Usuário criado");
    }

    public void readUsuario() {
        System.out.println("[READ] Usuários Cadastrados:");
        for (Document doc : docsUsuario.find()) {
            System.out.println(Usuario.fromDocument(doc));
        }
    }

    public void updateUsuarioIdade(String nome, int novaIdade) {
        docsUsuario.updateOne(Filters.eq("nome", nome), Updates.set("idade", novaIdade));
        System.out.println("[UPDATE] Usuário atualizado");
    }

    public void deleteUsuario(String nome) {
        docsUsuario.deleteOne(Filters.eq("nome", nome));
        System.out.println("[DELETE] Usuário removido");
    }
}
