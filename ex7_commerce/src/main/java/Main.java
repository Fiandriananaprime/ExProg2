public class Main {
    public static void main(String[] args) {

        Vetement v = new Vetement("T-shirt", 20000, 10, "M", "Noir", "coton");
        Electronique e = new Electronique("Téléphone", 800000, 5, "Samsung", 24);
        Livre l = new Livre("Java POO", 50000, 3, "Dupont", 300);

        System.out.println(v.afficherInfo());
        System.out.println("TTC: " + v.calculerPrixTTC());
        System.out.println("Stock: " + v.calculerValeurStock());

        System.out.println("------------");

        System.out.println(e.afficherInfo());
        System.out.println("TTC: " + e.calculerPrixTTC());
        System.out.println("Stock: " + e.calculerValeurStock());

        System.out.println("------------");

        System.out.println(l.afficherInfo());
        System.out.println("TTC: " + l.calculerPrixTTC());
        System.out.println("Stock: " + l.calculerValeurStock());
    }
}