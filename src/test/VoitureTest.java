import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class VoitureTest {

    @Test
    void testCreateVoiture(){
        String marque = "BMW";
        int prix = 42000;

        Voiture v1 = new Voiture(marque, prix);

        assertEquals(42000, v1.getPrix());
        assertEquals("BMW", v1.getMarque());

    }

    @Test
    void testSetVoiture(){
        String marque = "Ferrari";
        int prix = 120000;

        Voiture v2 = new Voiture(marque, prix);

        System.out.println(v2);

        v2.setMarque("Suzuki");

        System.out.println(v2);

        assertNotEquals(marque, v2.getMarque());

        v2.setPrix(80000);

        System.out.println(v2);

        assertNotEquals(prix, v2.getPrix());
    }

}
