import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAlgorithmes {
    @Test
    public void testBellmanFord(){
        GrapheListe graphe = construireGraphe();
        Valeur v = BellmanFord.resoudre(graphe,"A");
        //1ere serie de tests : teste chaque valeur de chaque sommet
        assertEquals(0, v.getValeur("A"), "A devrait etre egal a 0");
        assertEquals(12,v.getValeur("B"),"B devrait etre egal a 12");
        assertEquals(23,v.getValeur("E"),"E devrait etre egal a 22");
        assertEquals(66,v.getValeur("D"),"D devrait etre egal a 66");
        assertEquals(76,v.getValeur("C"),"C devrait etre egal a 76");
        //2nd serie de tests : teste si le chemin est correctement
        for(int i = 0; i<5;i++){
            assertEquals(listeTest().get(i),v.calculerChemin("C").get(i),"Le chemin n'est pas correctement ordonne");
        }
    }


    @Test
    public void testDijkstra() {
        GrapheListe graphe = construireGraphe();
        Dijkstra d = new Dijkstra();
        Valeur v = d.resoudre(graphe, "A");
        //1ere serie de tests : teste chaque valeur de chaque sommet
        assertEquals(0, v.getValeur("A"), "A devrait etre egal a 0");
        assertEquals(12,v.getValeur("B"),"B devrait etre egal a 12");
        assertEquals(23,v.getValeur("E"),"E devrait etre egal a 22");
        assertEquals(66,v.getValeur("D"),"D devrait etre egal a 66");
        assertEquals(76,v.getValeur("C"),"C devrait etre egal a 76");
        //2nd serie de tests : teste si le chemin est correctement
        for(int i = 0; i<5;i++){
            assertEquals(listeTest().get(i),v.calculerChemin("C").get(i),"Le chemin n'est pas correctement ordonne");
        }
    }

    /**
     * Methode construisant le graphe présent dans la SAE 2.02, page 12
     * Utilisation seulement dans les tests
     * @return Graphe de la SAE pour les tests
     */
    private GrapheListe construireGraphe() {
        GrapheListe graphe = new GrapheListe();
        //ajout des arcs et des noeuds
        graphe.ajouterArc("A","B",12);
        graphe.ajouterArc("A","D",87);
        graphe.ajouterArc("B","E",11);
        graphe.ajouterArc("E","D",43);
        graphe.ajouterArc("D","C",10);
        graphe.ajouterArc("C","A",19);
        graphe.ajouterArc("D","B",23);
        return graphe;
    }

    /**
     * Methode qui retourne la liste du chemin pour tester les methodes
     * @return liste contenant le chemin juste
     */
    private List<String> listeTest(){
        List<String> l = new ArrayList<>();
        l.add("Fin");
        l.add("A");
        l.add("B");
        l.add("E");
        l.add("D");
        l.add("C");
        return l;
    }
}
