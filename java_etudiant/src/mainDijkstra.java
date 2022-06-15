public class mainDijkstra {
    public static void main(String[] args) {
        // lecture des graphes à partir de fichier texte
        GrapheListe gl = new GrapheListe("generer.txt");
        // calcul des chemins les plus courts des noeuds donnees
        Algorithme dijksta = new Dijkstra();
        long debut = System.nanoTime();
        Valeur v = dijksta.resoudre(gl, "1");
        long fin = System.nanoTime();
        long dureenano = fin - debut;
        double dureeseconde = dureenano/1e9;
        System.out.println("Duree en nanoseconde " + dureenano);
        System.out.println("Duree en seconde " + dureeseconde);
        // affichage des chemins pour des noeuds donnees
        //System.out.println(v.toString());
        //System.out.println(v.calculerChemin("80"));
    }
}
