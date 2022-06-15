import java.util.ArrayList;
import java.util.List;

public class Dijkstra implements Algorithme{
    public Valeur resoudre(Graphe g, String depart){
        List<String> str = new ArrayList<String>();
        Valeur res = new Valeur();
        //initialisation
        //Pour chaque sommet ou noeud de G faire
        for (int i = 0; i<g.listeNoeuds().size(); i++){
            String nom = g.listeNoeuds().get(i);
            //v.distance <- infini
            res.setValeur(nom,Double.MAX_VALUE);
            //ajout le noeud dans la liste str
            str.add(nom);
        }
        // a.distance <- 0
        res.setValeur(depart, 0);
        res.setParent(depart, "fin");
        //seconde boucle : parcours
        //tant que la liste str est un ensemble non vide faire
        while (!str.isEmpty()){
            //affichage de l'objet valeur apres chaque iteration
            //System.out.println(res);
            int j = - 1;
            double petit = Double.MAX_VALUE;
            // recherche du sommet de str telle que u.distance est minimale
            //pour chaque sommet de str
            for (int i= 0; i< str.size(); i++){
                // si la plus petite valeur est inferieur a la valeur du neoud i
                if (petit > res.getValeur(str.get(i))){
                    //alors petit <- la valeur du noeud i
                    petit = res.getValeur(str.get(i));
                    // et j <- i
                    j = i;
                }
            }
            //enleve le noeud u de la listre str
            String u = str.remove(j);
            //pour chaque arc du noeud u faire
            for (int k= 0; k< g.suivants(u).size(); k++){
                double D = res.getValeur(u) + g.suivants(u).get(k).getCout();
                // si D< v.distance
                if (D < res.getValeur(g.suivants(u).get(k).getDest())){
                    //alors v.distance <- D
                    res.setValeur(g.suivants(u).get(k).getDest(), D);
                    // v.parent <- u
                    res.setParent(g.suivants(u).get(k).getDest(), u);
                }
            }

        }
        return res;
    }
}