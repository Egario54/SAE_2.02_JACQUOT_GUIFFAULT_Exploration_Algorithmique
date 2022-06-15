
/**
 * Interface qui implémente la résolution de graphes
 */
public interface Algorithme {
    /**
     * le methode resoudre permet de trouver le chemin le plus court du depart aux autres noeuds
     * en utilisant une methode a implementer
     * @param g le graphe
     * @param depart represente le noeud de depart
     * @return objet valeur correctent construit contenant les distances et les parents de chaque noeud
     */
    public Valeur resoudre(Graphe g, String depart);
}
