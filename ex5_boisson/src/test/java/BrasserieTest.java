import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class BrasserieTest {

    @Test
    void testAjouterEtRechercherBoisson() {
        Brasserie brasserie = new Brasserie();

        Quantite q = org.mockito.Mockito.mock(Quantite.class);

        Boisson b1 = new Boisson(1, "Coca Cola", q, 2.0);
        Boisson b2 = new Boisson(2, "Fanta Orange", q, 2.5);

        brasserie.ajouterBoisson(b1);
        brasserie.ajouterBoisson(b2);

        List<Boisson> res = brasserie.rechercherBoisson("coca");

        assertEquals(1, res.size());
        assertEquals("Coca Cola", res.get(0).getNom());
    }

    @Test
    void testRechercherClient() {
        Brasserie brasserie = new Brasserie();

        Client c1 = new Client(1, "Rakoto", "Jean", "rakoto@gmail.com", "0321234567");
        Client c2 = new Client(2, "Rabe", "Paul", "rabe@gmail.com", "0349876543");

        brasserie.ajouterClient(c1);
        brasserie.ajouterClient(c2);

        List<Client> resNom = brasserie.rechercherClient("rak");
        List<Client> resEmail = brasserie.rechercherClient("gmail");
        List<Client> resPrenom = brasserie.rechercherClient("paul");

        assertEquals(1, resNom.size());
        assertEquals(1, resEmail.size());
        assertEquals(1, resPrenom.size());
    }

    @Test
    void testCompterOperateurs() {
        Brasserie brasserie = new Brasserie();

        Client c1 = new Client(1, "A", "A", "a@mail.com", "0321111111");
        Client c2 = new Client(2, "B", "B", "b@mail.com", "0332222222");
        Client c3 = new Client(3, "C", "C", "c@mail.com", "0343333333");
        Client c4 = new Client(4, "D", "D", "d@mail.com", "0329999999");

        brasserie.ajouterClient(c1);
        brasserie.ajouterClient(c2);
        brasserie.ajouterClient(c3);
        brasserie.ajouterClient(c4);

        Map<String, Integer> map = brasserie.compterOperateurs();

        assertEquals(2, map.get("Orange"));
        assertEquals(1, map.get("Airtel"));
        assertEquals(1, map.get("Yas"));
    }
}