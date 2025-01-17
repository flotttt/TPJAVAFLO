import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDB {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public MongoDB(String connectionString, String dbName, String collectionName) {
        mongoClient = MongoClients.create(connectionString);
        database = mongoClient.getDatabase(dbName);
        collection = database.getCollection(collectionName);
    }

    public void ajouterUtilisateur(String nom, String email, String role) {
        Document utilisateur = new Document("nom", nom)
                .append("email", email)
                .append("role", role);
        collection.insertOne(utilisateur);
        System.out.println("Utilisateur ajouté : " + utilisateur.toJson());
    }

    public void listerUtilisateurs() {
        for (Document doc : collection.find()) {
            System.out.println(doc.toJson());
        }
    }

    public void fermerConnexion() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Connexion MongoDB fermée.");
        }
    }

    public static void main(String[] args) {
        String connectionString = "mongodb+srv://carmelohays:790SEBfv1lrZNPD2@cluster0.yd7bp.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
        MongoDB client = new MongoDB(connectionString, "FLODB", "utilisateurs");

        client.ajouterUtilisateur("Alice", "alice@gmail.com", "Membre");
        client.ajouterUtilisateur("Charlie", "charlie@gmail.com", "Membre");
        client.ajouterUtilisateur("Diana", "diana@gmail.com", "Membre");
        client.ajouterUtilisateur("Ethan", "ethan@gmail.com", "Membre");
        client.ajouterUtilisateur("Fiona", "fiona@gmail.com", "Membre");
        client.ajouterUtilisateur("George", "george@gmail.com", "Membre");
        client.ajouterUtilisateur("Hannah", "hannah@gmail.com", "Membre");
        client.ajouterUtilisateur("Ian", "ian@gmail.com", "Membre");
        client.ajouterUtilisateur("Julia", "julia@gmail.com", "Membre");
        client.ajouterUtilisateur("Kevin", "kevin@gmail.com", "Membre");

        client.ajouterUtilisateur("Boby", "boby@gmail.com", "Admin");
        client.ajouterUtilisateur("Eva", "eva@gmail.com", "Admin");
        client.ajouterUtilisateur("Frank", "frank@gmail.com", "Admin");
        client.ajouterUtilisateur("Grace", "grace@gmail.com", "Admin");
        client.ajouterUtilisateur("Henry", "henry@gmail.com", "Admin");
        client.ajouterUtilisateur("Isabelle", "isabelle@gmail.com", "Admin");
        client.ajouterUtilisateur("Jack", "jack@gmail.com", "Admin");
        client.ajouterUtilisateur("Karen", "karen@gmail.com", "Admin");
        client.ajouterUtilisateur("Louis", "louis@gmail.com", "Admin");
        client.ajouterUtilisateur("Mia", "mia@gmail.com", "Admin");

        System.out.println("Nom de la base de données : " + client.database.getName());
        System.out.println("Liste des utilisateurs :");
        client.listerUtilisateurs();

        client.fermerConnexion();
    }
}