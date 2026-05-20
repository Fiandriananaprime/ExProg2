import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BoissonTest {

    @Test
    void testConstructeurEtGetters() {
        Quantite quantite = Mockito.mock(Quantite.class);

        Boisson b = new Boisson(1, "Coca", quantite, 2.5);

        assertEquals(1, b.getId());
        assertEquals("Coca", b.getNom());
        assertEquals(quantite, b.getQuantite());
        assertEquals(2.5, b.getPrix());
    }

    @Test
    void testPrixValide() {
        Quantite quantite = Mockito.mock(Quantite.class);

        Boisson b = new Boisson(2, "Fanta", quantite, 0.0);

        assertTrue(b.getPrix() >= 0);
    }
}