public class Main {

    public static void main(String[]args){

        //Création du graphe à partir d'un fichier texte
        GrapheListe gl = new GrapheListe("Graphes/Graphe1.txt");
        //affichage du graphe(Q15) et de graphiz
        //System.out.println(gl.toString());

        //BellmanFord b = new BellmanFord();
        //System.out.println(b.resoudre(graphe, "A").toString());
        //System.out.println(b.resoudre(graphe, "A").calculerChemin("C"));

        // lecture des graphes à partir de fichier texte
        GrapheListe grapheListe = new GrapheListe("Graphes/Graphe101.txt");
        // calcul des chemins les plus courts des noeuds donnees
        Algorithme bellman = new BellmanFord();
        long debut = System.nanoTime();
        Valeur v = bellman.resoudre(grapheListe, "1");
        long fin = System.nanoTime();
        long dureenano = fin - debut;
        double dureeseconde = dureenano/1e9;
        System.out.println("Duree en nanoseconde " + dureenano);
        System.out.println("Duree en seconde " + dureeseconde);long temps = fin - debut ;
        System.out.println(temps);
        // affichage des chemins pour des noeuds donnees
        //System.out.println(v.toString());
        //System.out.println(v.calculerChemin("80"));
    }
}