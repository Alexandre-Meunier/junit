package test.suite;

import fr.r402.Voiture;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import static org.junit.jupiter.api.Assertions.*;

@Suite
@SuiteDisplayName("JUnit Platform Suite Demo")
@SelectPackages("example")
@IncludeClassNamePatterns(".*Tests")
public class SuiteVoitureTest {

    void test_CreateVoiture_Should_return_same_marque_and_prix_of_instanciate_car(){
        String marque = "BMW";
        double prix = 42000;
        Voiture v1 = new Voiture(marque, prix);

        String expectedMarque = "BMW";
        int expectedPrix = 42000;

        assertEquals(expectedMarque, v1.getMarque(), "Marque de la voiture incorrecte");
        assertEquals(expectedPrix, v1.getPrix(), "Prix de la voiture incorrect");
    }

    @Test
    void test_SetMarque_and_SetPrix_should_change_good_marque_and_prix(){
        String marqueOrigin = "Ferrari";
        double prixOrigin = 120000;
        Voiture v2 = new Voiture(marqueOrigin, prixOrigin);

        String expectedMarque = "Susuki";
        double expectedPrix = 80000;

        v2.setMarque(expectedMarque);
        v2.setPrix(expectedPrix);

        assertNotEquals(marqueOrigin, v2.getMarque(), "La marque n'a pas été modifié");
        assertEquals(expectedMarque, v2.getMarque(), "La marque modifié n'est pas le bon");

        assertNotEquals(prixOrigin, v2.getPrix(), "Le prix n'a pas été modifié");
        assertEquals(expectedPrix, v2.getPrix(), "Le prix modifié n'est pas le bon");
    }

    @Test
    void test_ToString_should_contains_same_marque_and_prix_of_instanciate_car(){
        String marque = "Peugeot";
        double prix = 5000;
        Voiture v3 = new Voiture(marque, prix);

        String toString = v3.toString();

        String expectedMarque = "Peugeot";
        double expectedPrix = 5000;

        assertTrue(toString.contains(expectedMarque), "La valeur retourné par toString ne contient pas la marque" + v3);

        assertTrue(toString.contains(String.valueOf(expectedPrix)), "La valeur retourné par toString ne contient pas le prix" + v3);
    }

    @Test
    void test_SetPrix_Return_Throws_Arithmetic_Exception_When_Prix_Is_Negative(){
        String marque = "Peugeot";
        double prix = -5000;

        assertThrows(ArithmeticException.class, () -> new Voiture(marque, prix), "Problème exception prix négatif");

    }

    @Test
    void test_equals_should_return_true_with_the_same_object_car(){
        String marque1 = "Peugeot";
        double prix1 = 5000;
        Voiture v1 = new Voiture(marque1, prix1);

        assertTrue(v1.equals(v1), "La voiture ne peux pas être différente d'elle même");
    }

    @Test
    void test_equals_should_return_true_with_the_other_same_object_car(){
        String marque1 = "Peugeot";
        double prix1 = 5000;
        Voiture v1 = new Voiture(marque1, prix1);

        String marque2 = "Peugeot";
        double prix2 = 5000;
        Voiture expectedv2 = new Voiture(marque2, prix2);

        assertTrue(v1.equals(expectedv2), "La voiture ne peux pas être différente d'une copie d'elle'");
    }

    @Test
    void test_equals_should_return_false_with_the_different_object_car(){
        String marque1 = "Peugeot";
        double prix1 = 5000;
        Voiture v1 = new Voiture(marque1, prix1);

        String marque2 = "BMW";
        double prix2 = 30000;
        Voiture expectedv2 = new Voiture(marque2, prix2);

        assertFalse(v1.equals(expectedv2), "Les voitures doivent être différents");
    }
}
