import java.io.*;
import java.util.Random;

public class GenererGraphes {
    private final static int TAILLE = 10;

    public void generer() throws FileNotFoundException {
       PrintWriter writer = new PrintWriter("generer.txt");
        Random r = new Random();
        Random rand = new Random();
        Random randlien = new Random();
        // pour chaque noeud
        for (int i= 1; i<TAILLE+1; i++){
            int apres = i + 1;
            int avant = i-1;
            int cout = rand.nextInt(30);
            if (i<TAILLE){
                writer.write(i + "\t" + apres + "\t" +  cout + "\n");
            }
            cout = rand.nextInt(30) + 1;
            if (i > 1){
                writer.write(i + "\t" + avant + "\t" + cout + "\n");
            }
            int connexion = r.nextInt(5);
            for(int j=0; j<connexion; j++){
                int lien = randlien.nextInt(TAILLE);
                cout = rand.nextInt(30) + 1 ;
                writer.write(i + "\t" + lien + "\t" +  cout + "\n");
            }
        }
        writer.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        GenererGraphes gg = new GenererGraphes();
        gg.generer();
    }
}
