import java.util.ArrayList;
import java.util.List;

public class BellmanFord implements Algorithme {
    /**
     * le methode resoudre permet de trouver le chemin le plus court du depart aux autres noeuds
     * en utilisant la methode du point fixe
     * @param g le graphe
     * @param depart represente le noeud de depart
     * @return objet valeur correctent construit contenant les distances et les parents de chaque noeud
     */
    public Valeur resoudre(Graphe g, String depart){
        Valeur val = new Valeur();

        // INITIALISATION
        //pour chaque noeud dans le graphe g
        for (int i =0;i < g.listeNoeuds().size() ; i++) {
            // on attribut +00 à chaque noeud dans le graphe
            val.setValeur(g.listeNoeuds().get(i), Double.MAX_VALUE);
        }
        // on attribut 0 au noeud de depart
        val.setValeur(depart, 0);
        val.setParent(depart, "fin");
        boolean continuer = true;
        // tant qu'on a pas atteint un point fixe, on continue la boucle
        while (continuer){
            //affichage de l'objet valeur apres chaque iteration
            //System.out.println(val);
            continuer = false;
            // pour chaque arc (u, v, poids) de g faire :
            for (int i = 0; i < g.listeNoeuds().size(); i++){
                for (int j = 0; j < g.suivants(g.listeNoeuds().get(i)).size(); j++){
                    // Si L(v) < L(u) + poids alors
                    String lv = g.suivants(g.listeNoeuds().get(i)).get(j).getDest();
                    double lv_valeur = val.getValeur(g.suivants(g.listeNoeuds().get(i)).get(j).getDest());
                    double lu = val.getValeur(g.listeNoeuds().get(i));
                    double poids = g.suivants(g.listeNoeuds().get(i)).get(j).getCout();
                    if ((lu + poids ) <  lv_valeur ){
                        //alors l(v) <- l(u) + poids
                        val.setValeur(lv, (lu + poids));
                        val.setParent(lv , g.listeNoeuds().get(i));
                        continuer = true;
                    }
                }
            }
        }
        return val;
    }
}
