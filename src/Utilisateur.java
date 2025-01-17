public abstract class Utilisateur {
    protected String nom;
    protected String email;

    public Utilisateur(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    public abstract void afficherRole();
}
