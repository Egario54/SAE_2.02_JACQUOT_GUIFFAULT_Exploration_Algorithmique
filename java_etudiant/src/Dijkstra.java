import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
    public Valeur resoudre(Graphe g, String depart){
        List<String> str = g.listeNoeuds();
        Valeur res = new Valeur();
        //initialisation
        for (int i = 0; i<g.listeNoeuds().size(); i++){
            String nom = g.listeNoeuds().get(i);
            if(nom == depart){
                res.setValeur(nom,0);
            }
            else res.setValeur(nom,Double.MAX_VALUE);
            res.setParent(nom,null);
        }
        //seconde boucle : parcours
        while (!q.isEmpty()){
            u <- un sommet de Q telle que u.distance est minimale
            /**
             * Minimum
             * Trouve_min(Q)
             * 1 mini := infini
             * 2 sommet := -1
             * 3 pour chaque sommet s de Q
             * 4    si d[s] < mini
             * 5    alors
             * 6        mini := d[s]
             * 7        sommet := s
             * 8 renvoyer sommet
             */





            Q <- Q \{u} // enlever le sommet u de la liste Q
            for (chaque sommet v de Q tel que l’arc(u,v) existe){
                D <- u.distance + poids(u,v)
                if (D <v.distance) {
                    v.distance <- D
                    v.parent <- u
                }
            }
        }
        return res;
    }
}
