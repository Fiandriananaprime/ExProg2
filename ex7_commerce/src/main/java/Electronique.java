public class Electronique extends Produit {
    private String marque;
    private int garantie; // en mois

    public Electronique(String nom, double prix, int quantite, String marque, int garantie) {
        super(nom, prix, quantite);
        this.marque = marque;
        this.garantie = garantie;
    }

    @Override
    public double calculerPrixTTC() {
        double taxe = 0.15;
        if (garantie > 12) {
            taxe += 0.05;
        }
        return prix * (1 + taxe);
    }

    @Override
    public String afficherInfo() {
        return super.afficherInfo() +
                ", Marque: " + marque +
                ", Garantie: " + garantie + " mois";
    }
}