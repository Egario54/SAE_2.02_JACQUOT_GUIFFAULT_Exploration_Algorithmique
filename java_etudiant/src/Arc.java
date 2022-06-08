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
    @param d destination
    @param c cout
     */
    public Arc(String d, double c){
        dest = d;
        cout = c;
    }

    /**
     * getteut de cout
     * @return cout
     */
    public double getCout() {
        return cout;
    }

    /**
     * getteur de destination
     * @return la destination
     */
    public String getDest() {
        return dest;
    }
}
