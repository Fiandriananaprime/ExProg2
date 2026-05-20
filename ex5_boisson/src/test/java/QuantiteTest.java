import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuantiteTest {

    @Test
    void testEnLitres_ml() {
        Quantite q = new Quantite(500, "ml");
        assertEquals(0.5, q.enLitres());
    }

    @Test
    void testEnLitres_litre() {
        Quantite q = new Quantite(2, "L");
        assertEquals(2.0, q.enLitres());
    }

    @Test
    void testGetters() {
        Quantite q = new Quantite(750, "ml");

        assertEquals(750, q.getValeur());
        assertEquals("ml", q.getUnite());
    }
}