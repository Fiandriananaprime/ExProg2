import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Commande {
    private int id;
    private LocalDateTime date;
    private Client client;
    private List<BoissonCommande> boissons = new ArrayList<>();

    public Commande(int id, Client client) {
        this.id = id;
        this.client = client;
        this.date = LocalDateTime.now();
    }

    public void ajouterBoisson(BoissonCommande bc) {
        boissons.add(bc);
    }

    public double totalLitres() {
        double total = 0;
        for (BoissonCommande bc : boissons) {
            total += bc.getQuantite() * bc.getBoisson().getQuantite().enLitres();
        }
        return total;
    }

    public List<BoissonCommande> getBoissons() {
        return boissons;
    }

    public Client getClient() {
        return client;
    }
}