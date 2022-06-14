import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
     * Constructeur qui construit deux listes vides (noms et noeuds) pour représenter les noeuds
     */
    public GrapheListe (){
        this.ensNom = new ArrayList<String>();
        this.ensNoeuds = new ArrayList<Noeud>();
    }

    /**
     * Constructeur qui prend un nom de fichier en parametre
     * et construit un graphe
     * @param nomFichier ne lom du fichier
     */
    public GrapheListe(String nomFichier){
        //création d'une liste pour l'instant vide
        this.ensNoeuds = new ArrayList<Noeud>();
        BufferedReader br = null;
        try {
            //charge le fichier
            br = new BufferedReader(new FileReader(nomFichier));
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        String ligne;
        try {
            //parcours de chaque ligne du fichier
            while ((ligne = br.readLine()) != null){
                String depart;
                String destination;
                double cout;
                //pour chaque ligne on prend le "depart", c'est a dire le nom du noeud
                depart=ligne.split("\t")[0];
                // puis la destination de l'arc
                destination = ligne.split("\t")[1];
                //et enfin le cout qui va de depart à destination
                cout = Double.parseDouble(ligne.split("\t")[2]);
                ajouterArc(depart, destination, cout);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Retourne une liste des noms de noeuds
     * @return Liste des noms des noeuds
     */
    @Override
    public List<String> listeNoeuds() {
        for (int i=0; i<ensNoeuds.size(); i++){
            ensNom.set(i, this.ensNoeuds.get(i).getNom());
        }
        return ensNom;
    }

    /**
     * Methode qui renvoie la liste des arcs d'un noeud
     *
     * @param n nom du noeud
     * @return la liste des arcs d'un noeud
     */
    @Override
    public List<Arc> suivants(String n) {
        Noeud noeud = new Noeud(n);
        for (int i=0; i<ensNoeuds.size(); i++){
            if (ensNoeuds.get(i).equals(noeud)){
                for (int j=0; j<ensNoeuds.get(i).getAdj().size(); j++){
                    return ensNoeuds.get(i).getAdj();
                }
            }
        }
        return null;
    }

    /**
     * méthode permettant d'ajouter des arcs à un noeud
     * @param depart le nom du noeud de depart
     * @param destination la destination de l'arc
     * @param cout le cout de l'arc
     */
    public void ajouterArc (String depart, String destination, double cout){
            Noeud n = new Noeud(depart);
            boolean trouve = false;
            //si "n" existe déja alors on lui ajoute juste un nouvel arc
            for (int i= 0; i<ensNoeuds.size(); i++){
                if (ensNoeuds.get(i).equals(n)){
                    ensNoeuds.get(i).ajouterArc(destination, cout);
                    trouve = true;
                }
            }
            //sinon on ajoute à "n" un nouvel arc et on ajoute n à la liste de noeud
            if (!trouve){
                n.ajouterArc(destination, cout);
                ensNoeuds.add(n);
            }
    }

    /**
     * méthode toString qui permet d'afficher le graphe sous une forme simplifiée
     * @return le graphe
     */
    @Override
    public String toString (){
        String aff= "";
        int taille = ensNoeuds.size();
        // pour chaque noeud
        for (int i= 0; i<taille; i++){
            Noeud Unoeud = ensNoeuds.get(i);
            // on affiche son nom
            aff += Unoeud.getNom() + " -> ";
            // pour chacun des noeuds on accède à leur arc
            for (int j=0; j<suivants(Unoeud.getNom()).size(); j++){
                Arc arcDuNoeud = Unoeud.getUnArc(j);
                //on affiche pour chaque noeud, ces arcs et les couts jusque ces arcs
                aff += arcDuNoeud.getDest() + "(" + arcDuNoeud.getCout() + ") ";
            }
            aff += "\n";
        }
        return aff;
    }

    /**
     *
     * @return une chaine représentant le graphe en respectant le format GraphViz
     */
    public String toGraphviz(){
        String aff= "digraph {\n";
        // pour chaque noeud
        for (int i = 0; i<ensNoeuds.size(); i++){
            // pour chaque arc d'un noeud
            for (int j=0; j<suivants(ensNoeuds.get(i).getNom()).size(); j++){
                aff += ensNoeuds.get(i).getNom() + " -> ";
                aff += ensNoeuds.get(i).getUnArc(j).getDest() + " [label = " + ensNoeuds.get(i).getUnArc(j).getCout() + "]";
                aff += "\n";
            }
        }
        aff +="}";
        return aff;
    }

    public List<Noeud> getEnsNoeuds() {
        return ensNoeuds;
    }
}