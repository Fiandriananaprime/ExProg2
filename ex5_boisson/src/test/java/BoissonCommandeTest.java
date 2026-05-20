import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoissonCommandeTest {

    @Test
    void testConstructeurEtGetters() {
        Quantite quantite = org.mockito.Mockito.mock(Quantite.class);
        Boisson boisson = new Boisson(1, "Sprite", quantite, 3.0);

        BoissonCommande bc = new BoissonCommande(10, boisson, 5);

        assertEquals(boisson, bc.getBoisson());
        assertEquals(5, bc.getQuantite());
    }

    @Test
    void testQuantitePositive() {
        Quantite quantite = org.mockito.Mockito.mock(Quantite.class);
        Boisson boisson = new Boisson(2, "Pepsi", quantite, 2.0);

        BoissonCommande bc = new BoissonCommande(11, boisson, 1);

        assertTrue(bc.getQuantite() > 0);
    }
}