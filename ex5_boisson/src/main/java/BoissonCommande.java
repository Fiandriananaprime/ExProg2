public class BoissonCommande {
    private int id;
    private Boisson boisson;
    private int quantite;

    public BoissonCommande(int id, Boisson boisson, int quantite) {
        this.id = id;
        this.boisson = boisson;
        this.quantite = quantite;
    }

    public Boisson getBoisson() { return boisson; }
    public int getQuantite() { return quantite; }
}