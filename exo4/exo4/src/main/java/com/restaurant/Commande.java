package com.restaurant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Commande {

    private int id;
    private LocalDate dateCommande;
    private Client client;
    private List<PlatCommande> platsCommandes;

    public Commande(int id, LocalDate dateCommande, Client client) {
        this.id = id;
        this.dateCommande = dateCommande;
        this.client = client;
        this.platsCommandes = new ArrayList<>();
    }

    public void ajouterPlatCommande(PlatCommande platCommande) {
        if (platCommande != null) {
            platsCommandes.add(platCommande);
        }
    }

    public boolean estVide() {
        return platsCommandes.isEmpty();
    }

    public List<PlatCommande> getPlatsCommandes() {
        return new ArrayList<>(platsCommandes);
    }

    public double getPrixTotal() {
        return platsCommandes.stream()
                .mapToDouble(PlatCommande::getSousTotal)
                .sum();
    }

    public void combiner(Commande autre) {
        if (autre != null) {
            for (PlatCommande pc : autre.getPlatsCommandes()) {
                pc.setCommande(this);
                this.platsCommandes.add(pc);
            }
        }
    }

    public double getPrixTotalParType(TypePlat type) {
        return platsCommandes.stream()
                .filter(pc -> pc.getPlat().getType() == type)
                .mapToDouble(PlatCommande::getSousTotal)
                .sum();
    }

    public Plat getPlatLePlusCher() {
        return platsCommandes.stream()
                .map(PlatCommande::getPlat)
                .max((p1, p2) -> Double.compare(p1.getPrixUnitaire(), p2.getPrixUnitaire()))
                .orElse(null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commande commande = (Commande) o;
        return id == commande.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Commande{id=" + id + ", date=" + dateCommande + ", client=" + client.getNom() + "}";
    }
}
