import java.util.*;

public class Brasserie {
    private List<Boisson> boissons = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();
    private List<Commande> commandes = new ArrayList<>();

    public void ajouterBoisson(Boisson b) {
        boissons.add(b);
    }

    public void ajouterClient(Client c) {
        clients.add(c);
    }

    public void ajouterCommande(Commande c) {
        commandes.add(c);
    }


    public List<Boisson> rechercherBoisson(String mot) {
        List<Boisson> res = new ArrayList<>();
        for (Boisson b : boissons) {
            if (b.getNom().toLowerCase().contains(mot.toLowerCase())) {
                res.add(b);
            }
        }
        return res;
    }


    public List<Client> rechercherClient(String mot) {
        List<Client> res = new ArrayList<>();
        for (Client c : clients) {
            if (
                    c.getNom().toLowerCase().contains(mot.toLowerCase()) ||
                            c.getPrenom().toLowerCase().contains(mot.toLowerCase()) ||
                            (c.getEmail() != null && c.getEmail().toLowerCase().contains(mot.toLowerCase()))
            ) {
                res.add(c);
            }
        }
        return res;
    }


    public Map<String, Integer> compterOperateurs() {
        Map<String, Integer> map = new HashMap<>();

        for (Client c : clients) {
            String tel = c.getTelephone();

            String operateur;
            if (tel.startsWith("032")) operateur = "Orange";
            else if (tel.startsWith("033")) operateur = "Airtel";
            else if (tel.startsWith("034")) operateur = "Yas";
            else operateur = "Autre";

            map.put(operateur, map.getOrDefault(operateur, 0) + 1);
        }

        return map;
    }
}