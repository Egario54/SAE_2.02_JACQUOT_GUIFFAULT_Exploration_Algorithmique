import java.util.ArrayList;
import java.util.List;

public class Noeud {

    private String nom;

    private List<Arc> adj;
    public Noeud (String n){
        this.nom = n;
        this.adj = new ArrayList<Arc>();
    }

    @Override
    public boolean equals(Object obj){
        Noeud n = (Noeud) obj;
        return ((n.getNom() == nom));
    }

    public String getNom(){
        return this.nom;
    }

    public void ajouterArc(String destination, double cout){
        Arc arc = new Arc (destination,cout);
        adj.add(arc);
    }
}
