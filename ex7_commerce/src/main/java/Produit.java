public class Produit {
    protected String nom;
    protected double prix;
    protected int quantite;

    public Produit(String nom, double prix, int quantite) {
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    public String getNom() { return nom; }
    public double getPrix() { return prix; }
    public int getQuantite() { return quantite; }

    public double calculerValeurStock() {
        return prix * quantite;
    }

    public double calculerPrixTTC() {
        return prix; // par défaut
    }

    public String afficherInfo() {
        return "Produit: " + nom + ", Prix: " + prix + ", Quantité: " + quantite;
    }
}