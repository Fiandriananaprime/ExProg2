package com.restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Plat {

    private int id;
    private String nom;
    private double prixUnitaire;
    private TypePlat type;
    private List<Ingredient> ingredients;

    public Plat(int id, String nom, double prixUnitaire, TypePlat type) {
        this.id = id;
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
        this.type = type;
        this.ingredients = new ArrayList<>();
    }

    public boolean contientIngredient(Ingredient ingredient) {
        return ingredients.contains(ingredient);
    }

    public void ajouterIngredient(Ingredient ingredient) {
        if (ingredient != null && !ingredients.contains(ingredient)) {
            ingredients.add(ingredient);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public TypePlat getType() {
        return type;
    }

    public void setType(TypePlat type) {
        this.type = type;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plat plat = (Plat) o;
        return id == plat.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Plat{id=" + id + ", nom='" + nom + "', prix=" + prixUnitaire + ", type=" + type + "}";
    }
}
