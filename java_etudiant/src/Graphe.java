public interface Graphe {
    /**
     * Methode renvoyant la liste des noeuds d'un graphe
     * @return liste des noeuds
     */
    public List<String> listeNoeuds();

    /**
     * Methode qui renvoie la liste des arcs d'un noeud
     * @param n nom des arcs d'un
     * @return Liste d'arcs
     */
    public List<Arc> suivants(String n);
}
