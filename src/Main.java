import java.util.List;

public class Main {
    public static void main(String[] args) {
        AddUtilisateur addUtilisateur = new AddUtilisateur();
        List<Utilisateur> utilisateurs = addUtilisateur.ajouterUtilisateurs();

        for (Utilisateur utilisateur : utilisateurs) {
            utilisateur.afficherRole();
        }
    }
}