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
        //affichage du graphe et de graphiz
        System.out.println(graphe.toString());
        System.out.println(graphe.toGraphviz());

        GrapheListe gl = new GrapheListe("Graphes/Graphe1.txt");
        System.out.println(gl.toString());
    }
}