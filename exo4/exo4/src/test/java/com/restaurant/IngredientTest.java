package com.restaurant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    @Test
    void equals_memeId_retourneTrue() {
        Ingredient i1 = new Ingredient(1, "Tomate");
        Ingredient i2 = new Ingredient(1, "Tomate");
        assertEquals(i1, i2);
    }

    @Test
    void equals_idDifferent_retourneFalse() {
        Ingredient i1 = new Ingredient(1, "Tomate");
        Ingredient i2 = new Ingredient(2, "Tomate");
        assertNotEquals(i1, i2);
    }

    @Test
    void equals_avecNull_retourneFalse() {
        Ingredient i1 = new Ingredient(1, "Tomate");
        assertNotEquals(i1, null);
    }

    @Test
    void equals_objetDifferent_retourneFalse() {
        Ingredient i1 = new Ingredient(1, "Tomate");
        assertNotEquals(i1, "Tomate");
    }

    @Test
    void getNom_retourneNomCorrect() {
        Ingredient i = new Ingredient(1, "Sel");
        assertEquals("Sel", i.getNom());
    }
}
