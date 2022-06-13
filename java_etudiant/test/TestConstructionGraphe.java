import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestConstructionGraphe {

    /**
     * Methode qui teste le 1er constructeur, ajoute les arcs et teste sa bonne construction
     */
    @Test
    public void test_01_testGrapheConstructeurVide(){
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A","B",12);
        graphe.ajouterArc("A","D",87);
        assertEquals("A -> B(12.0) D(87.0) \n",graphe.toString(), "Le graphe n'est pas celui attendu");
    }

    /**
     * Methode qui teste le second constructeur
     */
    @Test
    public void test_02_testGrapheFichier(){
        GrapheListe graphe = new GrapheListe("Graphes/GrapheTest.txt");
        assertEquals("1 -> 2(4.0) \n" + "1 -> 4(15.0) \n" +
                "2 -> 1(1.0) \n" + "2 -> 3(9.0) \n", graphe.toString(),"Le graphe n'est toujours pas celui attendu");
    }
}
