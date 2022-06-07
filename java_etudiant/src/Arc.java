public class Arc {
    /**
    Destination de l'arc
     */
    private String dest;

    /**
    Cout associe au deplacement via arc
     */
    private double cout;

    /**
    Constructeur prenant en compte
    @param String destination
    @param double cout
     */
    public Arc(String d, double c){
        dest = d;
        cout = c;
    }
}
