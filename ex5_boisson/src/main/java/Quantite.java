public class Quantite {
    private double valeur;
    private String unite; // "L" ou "ml"

    public Quantite(double valeur, String unite) {
        this.valeur = valeur;
        this.unite = unite;
    }

    public double enLitres() {
        if (unite.equalsIgnoreCase("ml")) {
            return valeur / 1000;
        }
        return valeur;
    }

    public double getValeur() { return valeur; }
    public String getUnite() { return unite; }
}