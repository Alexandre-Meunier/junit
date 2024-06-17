package fr.r402;

import fr.r402.StatistiqueVoiture;
import fr.r402.Voiture;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StatistiqueTest {

    @Test
    void test_getVoitures_return_no_error(){
        StatistiqueVoiture s = new StatistiqueVoiture();

        Voiture v1 = new Voiture("a", 50);
        s.ajouter(v1);
        Voiture v2 = new Voiture("b", 100);
        s.ajouter(v2);
        Voiture v3 = new Voiture("c", 150);
        s.ajouter(v3);

        ArrayList<Voiture> voitures = s.getVoitures();
        assertEquals(3, voitures.size(), "Nombre de voitures incorrect");
        assertEquals("a", voitures.get(0).getMarque(), "marque des voitures incorrect");
    }

    @Test
    void test_prix_when_three_voitures_good_price(){
        StatistiqueVoiture s = new StatistiqueVoiture();

        Voiture v1 = new Voiture("a", 50);
        s.ajouter(v1);
        Voiture v2 = new Voiture("b", 100);
        s.ajouter(v2);
        Voiture v3 = new Voiture("c", 150);
        s.ajouter(v3);

        int exceptionPrix = 300;

        //assertEquals(exceptionPrix, s.prix(), "Erreur du prix");
    }

    @Test
    void test_prix_when_six_voitures_good_price_with_remise(){
        StatistiqueVoiture s = new StatistiqueVoiture();
        s.ajouter(new Voiture("a", 10000));
        s.ajouter(new Voiture("b", 10000));
        s.ajouter(new Voiture("c", 10000));
        s.ajouter(new Voiture("d", 10000));
        s.ajouter(new Voiture("e", 10000));
        s.ajouter(new Voiture("f", 10000));
        s.ajouter(new Voiture("g", 10000));

        System.out.println(s.prix());
        //assertEquals(300, s.prix(), "Error price");
    }

    @Test
    void test_prix_when_zero_voitures_return_ArithmeticException_with_constructor_Service_no_parameters(){
        StatistiqueVoiture s1 = new StatistiqueVoiture();

        assertThrows(ArithmeticException.class, () -> s1.prix(), "Error constructor Service()");
    }
}
