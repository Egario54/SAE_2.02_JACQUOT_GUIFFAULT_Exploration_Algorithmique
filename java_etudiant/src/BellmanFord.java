import java.util.ArrayList;
import java.util.List;

public class BellmanFord {
    public static Valeur resoudre(Graphe g, String depart){
        Valeur val = new Valeur();
        //pour chaque noeud
        for (int i =0;i < g.listeNoeuds().size() ; i++) {
            val.setValeur(g.listeNoeuds().get(i), Double.MAX_VALUE);
            val.setParent(g.listeNoeuds().get(i), null);
        }
        val.setValeur(depart, 0);
        boolean continuer = true;
        while (continuer){
            continuer = false;
            // pour chaque arc
            for (int i = 0; i < g.listeNoeuds().size(); i++){
                for (int j = 0; j < g.suivants(g.listeNoeuds().get(i)).size(); j++){
                    if ( val.getValeur(g.listeNoeuds().get(i)) + g.suivants(g.listeNoeuds().get(i)).get(j).getCout() < val.getValeur(g.suivants(g.listeNoeuds().get(i)).get(j).getDest())){
                        System.out.println(val.getValeur(g.suivants(g.listeNoeuds().get(i)).get(j).getDest()));
                        continuer = true;
                    }
                }
            }
        }
        return val;
    }
}
