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

    /**
     * Constructeur qui construit deux listes (noms et noeuds) pour représenter les noeuds
     */
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
            Noeud n =new Noeud(depart);
            boolean trouve = false;
            for (int i= 0; i<ensNoeuds.size(); i++){
                if (ensNoeuds.get(i).equals(n)){
                    ensNoeuds.get(i).ajouterArc(destination, cout);
                    trouve = true;
                }
            }
            if (!trouve){
                n.ajouterArc(destination, cout);
                ensNoeuds.add(n);
            }
    }

    /**
     * Retourne une liste des noms de noeuds
     * @return Liste des noms des noeuds
     */
    @Override
    public List<String> listeNoeuds() {
        List<String > aff = null;
        for (int i=0; i<ensNoeuds.size(); i++){
            aff.set(i, this.ensNoeuds.get(i).getNom());
        }
        return aff;
    }

    /**
     * Methode qui renvoie la liste des arcs d'un noeud
     * @param n nom des arcs d'un
     * @return Liste d'arcs
     */
    @Override
    public List<Arc> suivants(String n) {
        Noeud noeud = new Noeud(n);
        List<Arc> arcs = null;
        for (int i=0; i<ensNoeuds.size(); i++){
            if (ensNoeuds.get(i).equals(noeud)){
                for (int j=0; j<ensNoeuds.get(i).getAdj().size(); j++){
                    arcs = ensNoeuds.get(i).getAdj();
                }
            }
        }
        return arcs;
    }

    @Override
    public String toString (){
        String aff= "";
        for (int i= 0; i<ensNoeuds.size(); i++){
            aff += ensNoeuds.get(i).getNom() + " -> ";
            for (int j=0; j<suivants(ensNoeuds.get(i).getNom()).size(); j++){
                aff += ensNoeuds.get(i).getUnArc(j).getDest() + "(" + ensNoeuds.get(i).getUnArc(j).getCout() + ")";
            }
            aff += "\n";
        }
        return aff;
    }

    public String toGraphviz(){
        String aff= "digraph {\n";
        for (int i = 0; i<ensNoeuds.size(); i++){
            for (int j=0; j<suivants(ensNoeuds.get(i).getNom()).size(); j++){
                aff += ensNoeuds.get(i).getNom() + " -> ";
                aff += ensNoeuds.get(i).getUnArc(j).getDest() + " [label = " + ensNoeuds.get(i).getUnArc(j).getCout() + "]";
                aff += "\n";
            }
        }
        aff +="}";
        return aff;
    }
}