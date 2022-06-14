import java.util.ArrayList;
import java.util.List;

public class Dijkstra implements Algorithme{
    public Valeur resoudre(Graphe g, String depart){
        List<String> str = new ArrayList<String>();
        Valeur res = new Valeur();
        //initialisation
        for (int i = 0; i<g.listeNoeuds().size(); i++){
            String nom = g.listeNoeuds().get(i);
            res.setValeur(nom,Double.MAX_VALUE);
            str.add(nom);
        }
        res.setValeur(depart, 0);
        res.setParent(depart, "fin");
        //seconde boucle : parcours

        while (!str.isEmpty()){
            int j = - 1;
            double petit = Double.MAX_VALUE;
            for (int i= 0; i< str.size(); i++){
                if (petit > res.getValeur(str.get(i))){
                    petit = res.getValeur(str.get(i));
                    j = i;
                }
            }
            String u = str.remove(j);
            for (int k= 0; k< g.suivants(u).size(); k++){
                double D = res.getValeur(u) + g.suivants(u).get(k).getCout();
                if (D < res.getValeur(g.suivants(u).get(k).getDest())){
                    res.setValeur(g.suivants(u).get(k).getDest(), D);
                    res.setParent(g.suivants(u).get(k).getDest(), u);
                }
            }

        }
        return res;
    }
}