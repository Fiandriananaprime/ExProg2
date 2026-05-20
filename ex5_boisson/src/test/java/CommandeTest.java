import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class CommandeTest {

    @Test
    void testConstructeurEtClient() {
        Client client = new Client(1, "Rakoto", "Jean", "0321234567", null);
        Commande c = new Commande(10, client);

        assertEquals(client, c.getClient());
        assertNotNull(c.getBoissons());
        assertTrue(c.getBoissons().isEmpty());
    }

    @Test
    void testAjouterBoisson() {
        Client client = new Client(2, "Rabe", "Paul", "0349876543", null);
        Commande c = new Commande(11, client);

        Quantite q = org.mockito.Mockito.mock(Quantite.class);
        org.mockito.Mockito.when(q.enLitres()).thenReturn(0.5);

        Boisson boisson = new Boisson(1, "Coca", q, 2.0);
        BoissonCommande bc = new BoissonCommande(1, boisson, 3);

        c.ajouterBoisson(bc);

        List<BoissonCommande> list = c.getBoissons();

        assertEquals(1, list.size());
        assertEquals(bc, list.get(0));
    }

    @Test
    void testTotalLitres() {
        Client client = new Client(3, "A", "B", "0320000000", null);
        Commande c = new Commande(12, client);

        Quantite q = org.mockito.Mockito.mock(Quantite.class);
        org.mockito.Mockito.when(q.enLitres()).thenReturn(0.5);

        Boisson b = new Boisson(1, "Fanta", q, 2.0);

        BoissonCommande bc1 = new BoissonCommande(1, b, 2);
        BoissonCommande bc2 = new BoissonCommande(2, b, 4);

        c.ajouterBoisson(bc1);
        c.ajouterBoisson(bc2);

        double total = c.totalLitres();

        assertEquals(3.0, total);
    }
}