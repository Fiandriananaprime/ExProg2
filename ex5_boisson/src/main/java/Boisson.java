public class Boisson {
    private int id;
    private String nom;
    private Quantite quantite;
    private double prix;

    public Boisson(int id, String nom, Quantite quantite, double prix) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public Quantite getQuantite() { return quantite; }
    public double getPrix() { return prix; }
}