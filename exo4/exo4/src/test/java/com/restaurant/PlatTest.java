package com.restaurant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlatTest {

    private Plat plat;
    private Ingredient tomate;
    private Ingredient fromage;

    @BeforeEach
    void setUp() {
        plat = new Plat(1, "Pizza Margherita", 8.50, TypePlat.RESISTANCE);
        tomate = new Ingredient(1, "Tomate");
        fromage = new Ingredient(2, "Fromage");
        plat.ajouterIngredient(tomate);
    }

    @Test
    void contientIngredient_ingredientPresent_retourneTrue() {
        assertTrue(plat.contientIngredient(tomate));
    }

    @Test
    void contientIngredient_ingredientAbsent_retourneFalse() {
        assertFalse(plat.contientIngredient(fromage));
    }

    @Test
    void ajouterIngredient_doublon_nAjoutePasDeuxFois() {
        plat.ajouterIngredient(tomate);
        assertEquals(1, plat.getIngredients().size());
    }

    @Test
    void ajouterIngredient_null_nePasCrash() {
        assertDoesNotThrow(() -> plat.ajouterIngredient(null));
    }

    @Test
    void equals_memeId_retourneTrue() {
        Plat autrePlat = new Plat(1, "Autre nom", 5.0, TypePlat.ENTREE);
        assertEquals(plat, autrePlat);
    }

    @Test
    void equals_idDifferent_retourneFalse() {
        Plat autrePlat = new Plat(2, "Pizza Margherita", 8.50, TypePlat.RESISTANCE);
        assertNotEquals(plat, autrePlat);
    }

    @Test
    void equals_avecNull_retourneFalse() {
        assertNotEquals(plat, null);
    }

    @Test
    void getType_retourneTypeCorrect() {
        assertEquals(TypePlat.RESISTANCE, plat.getType());
    }
}
