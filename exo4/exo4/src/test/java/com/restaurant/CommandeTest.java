package com.restaurant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommandeTest {

    private Client client;
    private Commande commande;
    private Plat pizza;
    private Plat coca;
    private Plat tiramisu;

    @BeforeEach
    void setUp() {
        client = new Client(1, "Rakoto", "Jean", "0341234567");
        commande = new Commande(1, LocalDate.now(), client);

        pizza = new Plat(1, "Pizza", 8.50, TypePlat.RESISTANCE);
        coca = new Plat(2, "Coca-Cola", 2.00, TypePlat.BOISSON);
        tiramisu = new Plat(3, "Tiramisu", 5.00, TypePlat.DESSERT);
    }

    @Test
    void estVide_commandeSansPlats_retourneTrue() {
        assertTrue(commande.estVide());
    }

    @Test
    void estVide_commandeAvecPlats_retourneFalse() {
        commande.ajouterPlatCommande(new PlatCommande(1, pizza, commande, 1));
        assertFalse(commande.estVide());
    }

    @Test
    void getPlatsCommandes_retourneTousLesPlats() {
        PlatCommande pc1 = new PlatCommande(1, pizza, commande, 2);
        PlatCommande pc2 = new PlatCommande(2, coca, commande, 1);
        commande.ajouterPlatCommande(pc1);
        commande.ajouterPlatCommande(pc2);

        List<PlatCommande> plats = commande.getPlatsCommandes();
        assertEquals(2, plats.size());
        assertTrue(plats.contains(pc1));
        assertTrue(plats.contains(pc2));
    }

    @Test
    void getPrixTotal_calculeCorrectement() {
        commande.ajouterPlatCommande(new PlatCommande(1, pizza, commande, 2));
        commande.ajouterPlatCommande(new PlatCommande(2, coca, commande, 3));

        double attendu = 8.50 * 2 + 2.00 * 3;
        assertEquals(attendu, commande.getPrixTotal(), 0.001);
    }

    @Test
    void getPrixTotal_commandeVide_retourneZero() {
        assertEquals(0.0, commande.getPrixTotal(), 0.001);
    }

    @Test
    void combiner_fusionneLesDeuxCommandes() {
        Commande autreCommande = new Commande(2, LocalDate.now(), client);

        commande.ajouterPlatCommande(new PlatCommande(1, pizza, commande, 1));
        autreCommande.ajouterPlatCommande(new PlatCommande(2, coca, autreCommande, 2));
        autreCommande.ajouterPlatCommande(new PlatCommande(3, tiramisu, autreCommande, 1));

        commande.combiner(autreCommande);

        assertEquals(3, commande.getPlatsCommandes().size());
    }

    @Test
    void combiner_avecCommandeNull_nePasCrash() {
        commande.ajouterPlatCommande(new PlatCommande(1, pizza, commande, 1));
        assertDoesNotThrow(() -> commande.combiner(null));
        assertEquals(1, commande.getPlatsCommandes().size());
    }

    @Test
    void combiner_platsCombinesSontRattachesALaPremiere() {
        Commande autreCommande = new Commande(2, LocalDate.now(), client);
        PlatCommande pc = new PlatCommande(2, coca, autreCommande, 1);
        autreCommande.ajouterPlatCommande(pc);

        commande.combiner(autreCommande);

        assertEquals(commande, pc.getCommande());
    }

    @Test
    void getPrixTotalParType_retournePrixBoissons() {
        commande.ajouterPlatCommande(new PlatCommande(1, pizza, commande, 1));
        commande.ajouterPlatCommande(new PlatCommande(2, coca, commande, 3));
        commande.ajouterPlatCommande(new PlatCommande(3, tiramisu, commande, 2));

        double attendu = 2.00 * 3;
        assertEquals(attendu, commande.getPrixTotalParType(TypePlat.BOISSON), 0.001);
    }

    @Test
    void getPrixTotalParType_typeAbsent_retourneZero() {
        commande.ajouterPlatCommande(new PlatCommande(1, pizza, commande, 1));

        assertEquals(0.0, commande.getPrixTotalParType(TypePlat.ENTREE), 0.001);
    }

    @Test
    void getPlatLePlusCher_retournePlatAvecPrixMax() {
        commande.ajouterPlatCommande(new PlatCommande(1, pizza, commande, 1));
        commande.ajouterPlatCommande(new PlatCommande(2, coca, commande, 1));
        commande.ajouterPlatCommande(new PlatCommande(3, tiramisu, commande, 1));

        Plat plusCher = commande.getPlatLePlusCher();
        assertEquals(pizza, plusCher);
    }

    @Test
    void getPlatLePlusCher_commandeVide_retourneNull() {
        assertNull(commande.getPlatLePlusCher());
    }

    @Test
    void equals_memeId_retourneTrue() {
        Commande autre = new Commande(1, LocalDate.now().plusDays(1), client);
        assertEquals(commande, autre);
    }

    @Test
    void equals_idDifferent_retourneFalse() {
        Commande autre = new Commande(2, LocalDate.now(), client);
        assertNotEquals(commande, autre);
    }
}
