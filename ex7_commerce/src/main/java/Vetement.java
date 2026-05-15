public class Vetement extends Produit {
    private String taille;
    private String couleur;
    private String matiere;

    public Vetement(String nom, double prix, int quantite, String taille, String couleur, String matiere) {
        super(nom, prix, quantite);
        this.taille = taille;
        this.couleur = couleur;
        this.matiere = matiere;
    }

    @Override
    public double calculerPrixTTC() {
        double taux;

        switch (matiere.toLowerCase()) {
            case "coton":
                taux = 0.10;
                break;
            case "cuir":
                taux = 0.05;
                break;
            default:
                taux = 0.02;
        }

        return prix * (1 + taux);
    }

    @Override
    public String afficherInfo() {
        return super.afficherInfo() +
                ", Taille: " + taille +
                ", Couleur: " + couleur +
                ", Matière: " + matiere;
    }
}