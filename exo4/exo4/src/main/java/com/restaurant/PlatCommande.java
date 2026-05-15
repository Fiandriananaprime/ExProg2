package com.restaurant;

import java.util.Objects;

public class PlatCommande {

    private int id;
    private Plat plat;
    private Commande commande;
    private int quantite;

    public PlatCommande(int id, Plat plat, Commande commande, int quantite) {
        this.id = id;
        this.plat = plat;
        this.commande = commande;
        this.quantite = quantite;
    }

    public double getSousTotal() {
        return plat.getPrixUnitaire() * quantite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Plat getPlat() {
        return plat;
    }

    public void setPlat(Plat plat) {
        this.plat = plat;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlatCommande that = (PlatCommande) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "PlatCommande{id=" + id + ", plat=" + plat.getNom() + ", quantite=" + quantite + "}";
    }
}
