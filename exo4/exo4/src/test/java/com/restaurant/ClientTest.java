package com.restaurant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void equals_memeId_retourneTrue() {
        Client c1 = new Client(1, "Rakoto", "Jean", "0341234567");
        Client c2 = new Client(1, "Rakoto", "Jean", "0341234567");
        assertEquals(c1, c2);
    }

    @Test
    void equals_idDifferent_retourneFalse() {
        Client c1 = new Client(1, "Rakoto", "Jean", "0341234567");
        Client c2 = new Client(2, "Rakoto", "Jean", "0341234567");
        assertNotEquals(c1, c2);
    }

    @Test
    void equals_avecNull_retourneFalse() {
        Client c1 = new Client(1, "Rakoto", "Jean", "0341234567");
        assertNotEquals(c1, null);
    }

    @Test
    void getters_retournentValeursCorrectes() {
        Client c = new Client(5, "Rabe", "Marie", "0347654321");
        assertEquals(5, c.getId());
        assertEquals("Rabe", c.getNom());
        assertEquals("Marie", c.getPrenom());
        assertEquals("0347654321", c.getContact());
    }
}
