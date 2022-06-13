import java.util.ArrayList;
import java.util.List;

public class BellmanFord {
    public static Valeur resoudre(Graphe g, String depart){
        Valeur val = null;
        int taille = g.listeNoeuds().size();
        //pour chaque noeud
        for (int i =0; taille<i ; i++) {
            val.setValeur(g.listeNoeuds().get(i), Double.MAX_VALUE);
            // pour chaque arc
            for (int j = 0; j < g.suivants(g.listeNoeuds().get(i)).size(); j++){
                // je dis qui est le daron de qui
                val.setParent(g.suivants(g.listeNoeuds().get(i)).get(i).getDest(), g.listeNoeuds().get(i));
            }
        }
        val.setValeur(depart, 0);
        boolean continuer = true;
        while (continuer){
            continuer = false;
            // pour chaque noeud
            for (int i = 0; i < g.listeNoeuds().size(); i++){
                // nom est le nom du noeud
                String nom = g.listeNoeuds().get(i);
                //pour chaque arc du noeud
                for (int j = 0; j < g.suivants(nom).size(); i++){
                    // si  cout de l'arc j du noeud i  + cout du noeud parent > cout de la valeur i
                    if ( g.suivants(nom).get(j).getCout() + val.getValeur(val.getParent(nom)) < val.getValeur(nom)){
                        val.setValeur(nom, g.suivants(nom).get(j).getCout() + val.getValeur(val.getParent(nom)));
                        val.setParent(nom, val.getParent(nom));
                        continuer = true;
                    }
                }
            }
        }
        return val;
    }
}
