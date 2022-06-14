import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenererGraphes {
    private final static int TAILLE = 100;

    public void generer() throws FileNotFoundException {
       PrintWriter writer = new PrintWriter("generer.txt");
        Random r = new Random();
        Random rand = new Random();
        Random randlien = new Random();
        // pour chaque
        for (int i= 0; i<TAILLE; i++){
            int apres = i + 1;
            int avant = i-1;
            int cout = rand.nextInt(30);
            if (i<TAILLE){
                writer.write(i + "\t" + apres + "\t" +  cout + "\n");
            }
            System.out.println(i + " " +  apres  + " " + cout);
            cout = rand.nextInt(30);
            if (i > 0){
                writer.write(i + "\t" + avant + "\t" + cout + "\n");
            }

            int connexion = r.nextInt(4);
            for(int j=0; j<connexion; j++){
                int lien = randlien.nextInt(TAILLE);
                cout = rand.nextInt(30);
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
