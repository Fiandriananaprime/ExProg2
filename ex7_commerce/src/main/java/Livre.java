public class Livre extends Produit {
    private String auteur;
    private int nombrePages;

    public Livre(String nom, double prix, int quantite, String auteur, int nombrePages) {
        super(nom, prix, quantite);
        this.auteur = auteur;
        this.nombrePages = nombrePages;
    }

    @Override
    public double calculerPrixTTC() {
        return prix * (1 + 0.055);
    }

    @Override
    public String afficherInfo() {
        return super.afficherInfo() +
                ", Auteur: " + auteur +
                ", Pages: " + nombrePages;
    }
}