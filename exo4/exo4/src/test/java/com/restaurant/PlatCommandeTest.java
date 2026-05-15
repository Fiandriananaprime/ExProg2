package com.restaurant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PlatCommandeTest {

    private Plat plat;
    private Commande commande;
    private PlatCommande platCommande;

    @BeforeEach
    void setUp() {
        plat = new Plat(1, "Burger", 7.00, TypePlat.SNACK);
        Client client = new Client(1, "Rabe", "Luc", "0321234567");
        commande = new Commande(1, LocalDate.now(), client);
        platCommande = new PlatCommande(1, plat, commande, 3);
    }

    @Test
    void getSousTotal_calculeCorrectement() {
        assertEquals(21.00, platCommande.getSousTotal(), 0.001);
    }

    @Test
    void getSousTotal_quantiteUn_retournePrixUnitaire() {
        PlatCommande pc = new PlatCommande(2, plat, commande, 1);
        assertEquals(7.00, pc.getSousTotal(), 0.001);
    }

    @Test
    void equals_memeId_retourneTrue() {
        PlatCommande autre = new PlatCommande(1, plat, commande, 5);
        assertEquals(platCommande, autre);
    }

    @Test
    void equals_idDifferent_retourneFalse() {
        PlatCommande autre = new PlatCommande(2, plat, commande, 3);
        assertNotEquals(platCommande, autre);
    }

    @Test
    void getters_retournentValeursCorrectes() {
        assertEquals(1, platCommande.getId());
        assertEquals(plat, platCommande.getPlat());
        assertEquals(commande, platCommande.getCommande());
        assertEquals(3, platCommande.getQuantite());
    }
}
