public class Main {
    public static void main(String[]args){
        //Création d'un graphe
        GrapheListe graphe = new GrapheListe();
        //ajout des arcs et des noeuds
        graphe.ajouterArc("A","B",12);
        graphe.ajouterArc("A","D",87);
        graphe.ajouterArc("B","E",11);
        graphe.ajouterArc("E","D",43);
        graphe.ajouterArc("D","C",10);
        graphe.ajouterArc("C","A",19);
        graphe.ajouterArc("D","B",23);


        //Création du graphe à partir d'un fichier texte
        GrapheListe gl = new GrapheListe("Graphes/Graphe1.txt");
        //affichage du graphe et de graphiz
        //System.out.println(graphe.toString());
        //System.out.println(graphe.toGraphviz());

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