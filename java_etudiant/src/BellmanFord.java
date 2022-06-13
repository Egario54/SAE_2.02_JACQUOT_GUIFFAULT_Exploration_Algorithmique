import java.util.ArrayList;
import java.util.List;

public class BellmanFord {
    /**
     * le methode resoudre permet de trouvre le chemin le plus de depart aux autres noeud
     * en utilisant la methode du point fixe
     * @param g le graphe
     * @param depart represente le noeud de depart
     * @return objet valeur correctent construit contenant les distances et les parents de chaque noeud
     */
    public static Valeur resoudre(Graphe g, String depart){
        Valeur val = new Valeur();

        // INITIALISATION
        //pour chaque noeud dans le graphe g
        for (int i =0;i < g.listeNoeuds().size() ; i++) {
            // on attribut +00 à chaque noeud dans le graphe
            val.setValeur(g.listeNoeuds().get(i), Double.MAX_VALUE);
        }
        // on attribut 0 au noeud de depart
        val.setValeur(depart, 0);
        boolean continuer = true;
        // tant qu'on a pas atteint un point fixe, on continue la boucle
        while (continuer){
            continuer = false;
            // pour chaque arc (u, v, poids) de g faire :
            for (int i = 0; i < g.listeNoeuds().size(); i++){
                for (int j = 0; j < g.suivants(g.listeNoeuds().get(i)).size(); j++){
                    // Si L(v) <- L(u) + poids alors
                    if (val.getValeur(g.listeNoeuds().get(i)) + g.suivants(g.listeNoeuds().get(i)).get(j).getCout() < val.getValeur(g.suivants(g.listeNoeuds().get(i)).get(j).getDest())){
                        val.setValeur(g.suivants(g.listeNoeuds().get(i)).get(j).getDest(), val.getValeur(g.listeNoeuds().get(i)) + g.suivants(g.listeNoeuds().get(i)).get(j).getCout());
                        val.setParent(g.suivants(g.listeNoeuds().get(i)).get(j).getDest() , g.listeNoeuds().get(i));
                        continuer = true;
                    }
                }
            }
        }
        return val;
    }
}
