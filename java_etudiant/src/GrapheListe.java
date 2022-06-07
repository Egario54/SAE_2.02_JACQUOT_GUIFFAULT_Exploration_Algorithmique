import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe{

    /**
     * contient les noms des objets noeuds
     */
    private List<String> ensNom;


    /**
     * est une liste d'objet Noeuds permettant de stocker les arcs
     */
    private List<Noeud> ensNoeuds;

    public GrapheListe (){
        this.ensNom = new ArrayList<String>();
        this.ensNoeuds = new ArrayList<Noeud>();
    }


    /**
     * méthode permettant d'ajouter des noeuds et des arcs
     * @param depart le nom du noeud de depart
     * @param destination la destination de l'arc
     * @param cout le cout de l'arc
     */
    public void ajouterArc (String depart, String destination, double cout){
        for (int i=0; i<ensNoeuds.size(); i++){
            if (ensNoeuds.get(i).equals(depart)){
                ensNoeuds.get(i).ajouterArc(destination, cout);
            }
        }
    }

    @Override
    public List<String> listeNoeuds() {
        List<String > aff = null;
        for (int i=0; i<ensNom.size(); i++){
            aff += this.ensNoeuds.get(i).getNom();
        }
        return aff;
    }

    @Override
    public List<Arc> suivants(String n) {
        return null;
    }
}
