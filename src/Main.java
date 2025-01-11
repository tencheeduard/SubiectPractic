import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("punkte.txt");

        // Avem nevoie de un FileReader si un BufferedReader.
        FileReader fileReader = new FileReader(file);
        // bufferedReader il ia pe fileReader ca parametru la constructor
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // folosim un set pentru ca nu poate contine dubluri si le sorteaza automat
        SortedSet<String> names = new TreeSet<>();

        // citim prima linie
        String line = bufferedReader.readLine();
        while(line != null)
        {
            // impartim linia la fiecare &
            String[] entries = line.split("&");

            // adaugam numele studentului
            names.add(entries[1]);

            // citim urmatoarea linie
            line = bufferedReader.readLine();
        }

        // printam fiecare nume
        for(String name : names)
            System.out.println(name);
    }
}