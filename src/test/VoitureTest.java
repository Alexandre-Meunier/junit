import data.Voiture;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class VoitureTest {

    @Test
    void testCreateVoiture(){
        String marque = "BMW";
        int prix = 42000;
        Voiture v1 = new Voiture(marque, prix);

        String expectedMarque = "BMW";
        int expectedPrix = 42000;

        assertEquals(expectedMarque, v1.getMarque(), "Marque de la voiture incorrecte");
        assertEquals(expectedPrix, v1.getPrix(), "Prix de la voiture incorrect");
    }

    @Test
    void testSetVoiture(){
        String marqueOrigin = "Ferrari";
        int prixOrigin = 120000;
        Voiture v2 = new Voiture(marqueOrigin, prixOrigin);

        String expectedMarque = "Susuki";
        int expectedPrix = 80000;

        v2.setMarque(expectedMarque);
        v2.setPrix(expectedPrix);

        assertNotEquals(marqueOrigin, v2.getMarque(), "La marque n'a pas été modifié");
        assertEquals(expectedMarque, v2.getMarque(), "La marque modifié n'est pas le bon");

        assertNotEquals(prixOrigin, v2.getPrix(), "Le prix n'a pas été modifié");
        assertEquals(expectedPrix, v2.getPrix(), "Le prix modifié n'est pas le bon");
    }

    @Test
    void testToStringVoiture(){
        String marque = "Peugeot";
        int prix = 5000;
        Voiture v3 = new Voiture(marque, prix);

        String toString = v3.toString();

        String expectedMarque = "Peugeot";
        int expectedPrix = 5000;

        assertTrue(toString.contains(expectedMarque), "La valeur retourné par toString ne contient pas la marque" + v3);

        assertTrue(toString.contains(String.valueOf(expectedPrix)), "La valeur retourné par toString ne contient pas le prix" + v3);
    }

    @Test
    void test_SetPrix_Return_Throws_Arithmetic_Exception_When_Prix_Is_Negative(){
        String marque = "Peugeot";
        int prix = -5000;

        assertThrows(ArithmeticException.class, () -> new Voiture(marque, prix), "Problème exception prix négatif");

    }

}
