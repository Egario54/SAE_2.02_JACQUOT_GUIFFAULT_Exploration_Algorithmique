import java.util.ArrayList;
import java.util.List;

public class Noeud {

    /**
     * Nom du noeud
     */
    private String nom;

    /**
    Liste des arcs qui partent du noeud
     */
    private List<Arc> adj;

    /**
    Crée un noeud nomme avec une liste vide d'arcs
    @Param String nom du noeud
     */
    public Noeud (String n){
        this.nom = n;
        this.adj = new ArrayList<Arc>();
    }

    /**
    Methode qui compare le nom de deux noeuds
    @param Object noeud
    @return boolean
     */
    @Override
    public boolean equals(Object obj){
        Noeud n = (Noeud) obj;
        return ((n.getNom() == nom));
    }

    /**
    Methode qui crée un arc et qui l'ajoute a la liste
    @param String destination de l'arc
    @param double cout de l'arc
     */
    public void ajouterArc(String destination, double cout){
        Arc arc = new Arc (destination,cout);
        adj.add(arc);
    }

    public String getNom(){
        return this.nom;
    }

    public List<Arc> getAdj(){
        return adj;
    }

}
