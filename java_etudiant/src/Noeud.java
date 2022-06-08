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
     * Constructeur
     * Crée un noeud nomme avec une liste vide d'arcs
     @param n : nom du noeud
     */
    public Noeud (String n){
        this.nom = n;
        this.adj = new ArrayList<Arc>();
    }

    /**
     * Methode qui compare le nom de deux noeuds
     * deux noeuds sont egaux si leur nom sont égaux
    @param obj noeud
    @return boolean
     */
    @Override
    public boolean equals(Object obj){
        Noeud n = (Noeud) obj;
        return ((n.getNom() == nom));
    }

    /**
    Methode qui crée un arc et qui l'ajoute a la liste
    @param destination destination de l'arc
    @param cout cout de l'arc
     */
    public void ajouterArc(String destination, double cout){
        Arc arc = new Arc (destination,cout);
        adj.add(arc);
    }



    //GETTEUR

    /**
     * getteur de nom
     * @return retourne le nom
     */
    public String getNom(){
        return this.nom;
    }

    /**
     * getteur de la liste d'arc
     * @return la liste d'arc
     */
    public List<Arc> getAdj(){
        return adj;
    }

    /**
     * retourne un arc à l'endroit i
     * @param i la place dans la liste
     * @return l'arc à la position i
     */
    public Arc getUnArc (int i){
        return adj.get(i);
    }

}
