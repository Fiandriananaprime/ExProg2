import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClientTest {

    @Test
    void testConstructeurEtGetters() {
        Client c = new Client(1, "Rakoto", "Jean", "0321234567", "rakoto@mail.com");

        assertEquals("Rakoto", c.getNom());
        assertEquals("Jean", c.getPrenom());
        assertEquals("0321234567", c.getTelephone());
        assertEquals("rakoto@mail.com", c.getEmail());
    }

    @Test
    void testEmailNull() {
        Client c = new Client(2, "Rabe", "Paul", "0349876543", null);

        assertNull(c.getEmail());
    }
}