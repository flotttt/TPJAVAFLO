import java.util.ArrayList;
import java.util.List;

public class AddUtilisateur {
    public List<Utilisateur> ajouterUtilisateurs() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        Utilisateur membre1 = new Membre("Alice", "alice@gmail.com");
        Utilisateur membre2 = new Membre("Charlie", "charlie@gmail.com");
        Utilisateur membre3 = new Membre("Diana", "diana@gmail.com");
        Utilisateur membre4 = new Membre("Ethan", "ethan@gmail.com");
        Utilisateur membre5 = new Membre("Fiona", "fiona@gmail.com");
        Utilisateur membre6 = new Membre("George", "george@gmail.com");
        Utilisateur membre7 = new Membre("Hannah", "hannah@gmail.com");
        Utilisateur membre8 = new Membre("Ian", "ian@gmail.com");
        Utilisateur membre9 = new Membre("Julia", "julia@gmail.com");
        Utilisateur membre10 = new Membre("Kevin", "kevin@gmail.com");

        Utilisateur admin1 = new Admin("Boby", "boby@gmail.com");
        Utilisateur admin2 = new Admin("Eva", "eva@gmail.com");
        Utilisateur admin3 = new Admin("Frank", "frank@gmail.com");
        Utilisateur admin4 = new Admin("Grace", "grace@gmail.com");
        Utilisateur admin5 = new Admin("Henry", "henry@gmail.com");
        Utilisateur admin6 = new Admin("Isabelle", "isabelle@gmail.com");
        Utilisateur admin7 = new Admin("Jack", "jack@gmail.com");
        Utilisateur admin8 = new Admin("Karen", "karen@gmail.com");
        Utilisateur admin9 = new Admin("Louis", "louis@gmail.com");
        Utilisateur admin10 = new Admin("Mia", "mia@gmail.com");

        utilisateurs.add(membre1);
        utilisateurs.add(membre2);
        utilisateurs.add(membre3);
        utilisateurs.add(membre4);
        utilisateurs.add(membre5);
        utilisateurs.add(membre6);
        utilisateurs.add(membre7);
        utilisateurs.add(membre8);
        utilisateurs.add(membre9);
        utilisateurs.add(membre10);

        utilisateurs.add(admin1);
        utilisateurs.add(admin2);
        utilisateurs.add(admin3);
        utilisateurs.add(admin4);
        utilisateurs.add(admin5);
        utilisateurs.add(admin6);
        utilisateurs.add(admin7);
        utilisateurs.add(admin8);
        utilisateurs.add(admin9);
        utilisateurs.add(admin10);

        return utilisateurs;
    }
}