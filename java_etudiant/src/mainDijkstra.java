public class mainDijkstra {
    public static void main(String[] args) {
        // lecture des graphes à partir de fichier texte
        GrapheListe gl = new GrapheListe("Graphes/Graphe101.txt");
        // calcul des chemins les plus courts des noeuds donnees
        Algorithme dijksta = new Dijkstra();
        long debut = System.nanoTime();
        Valeur v = dijksta.resoudre(gl, "1");
        long fin = System.nanoTime();
        long dureenano = fin - debut;
        double dureeseconde = dureenano/1e9;
        // affichage des chemins pour des noeuds donnees
        //System.out.println(v.toString());
        //System.out.println(v.calculerChemin("80"));

        //affichage de la duree de l'execution
        System.out.println("Duree en nanoseconde " + dureenano);
        System.out.println("Duree en seconde " + dureeseconde);

        //affichage du graphe et de graphiz
        System.out.println(gl.toString());
        System.out.println(gl.toGraphviz());
    }
}
