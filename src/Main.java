import java.awt.image.ImageProducer;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("punkte.txt");

        // Avem nevoie de un FileReader si un BufferedReader.
        FileReader fileReader = new FileReader(file);
        // bufferedReader il ia pe fileReader ca parametru la constructor
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // folosim un map pentru ca e practic un dictionar
        Map<String, Integer> dictionary = new HashMap<>();

        // citim prima linie
        String line = bufferedReader.readLine();
        while(line != null)
        {
            // impartim linia la fiecare &
            String[] entries = line.split("&");

            // daca dictionarul nu contine numele casei, il adaugam, si cu punctele ei
            if(dictionary.containsKey(entries[2]) == false)
                dictionary.put(entries[2], Integer.parseInt(entries[4]));
            // daca da, atunci doar adauga punctele
            else
                dictionary.put(entries[2], dictionary.get(entries[2]) + Integer.parseInt(entries[4]));

            // citim urmatoarea linie
            line = bufferedReader.readLine();
        }

        // facem o lista din numele caselor
        List<String> sortedHouseList = new ArrayList<>(dictionary.keySet());

        // cel mai simplu algoritm de sortare, dar deloc eficient [O(n^2)]

        // comparam fiecare element cu fiecare celalalt element. daca cel de pe pozitia i e mai mare decat cel de pe pozitia j, le interschimbam
        for(int i = 0; i < sortedHouseList.size(); i++)
        {
            for(int j = 0; j < sortedHouseList.size(); j++)
            {
                if(dictionary.get(sortedHouseList.get(i)) > dictionary.get(sortedHouseList.get(j)))
                {
                    String aux = sortedHouseList.get(j);
                    sortedHouseList.set(j, sortedHouseList.get(i));
                    sortedHouseList.set(i, aux);
                }
            }
        }


        // la fel ca la readere, avem un FileWriter si un BufferedWriter.
        FileWriter fileWriter = new FileWriter("ergebnis.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // scriem fiecare casa si cate puncte are
        for(String house : sortedHouseList)
            bufferedWriter.write(house + "#" + dictionary.get(house) + "\n");

        // apoi scriem tot si inchidem fisierul

        // sa nu uiti de flush, e foarte probabil sa nu iti scrie in fisier altfel.
        bufferedWriter.flush();
        bufferedWriter.close();


        //// metoda mai corecta (si mult mai scurta), dar putin mai greu de inteles mai jos \/

        ////  luam toate perechiile de <String, Integer> si le punem intr-o lista
        ////  (lista e o lista de perechi)

        // List<Map.Entry<String, Integer>> sortedHouseList = new ArrayList<>(dictionary.entrySet());

        ////    in functia asta lambda, compari valoarea (integer-ul) de la perechea 1, cu valoarea de la perechea 2.
        ////    rezultatul e folosit automat pentru functia de .sort()
        ////    daca compari cu e2 si dupa cu e1, iti da descrescator
        ////    invers iti da crescator
        
        // sortedHouseList.sort( (e1, e2) -> e2.getValue().compareTo(e1.getValue()) );

        ////    mai tarziu ai face asa:

        // for(Map.Entry<String, Integer> entry : sortedHouseList)
        //
        //                    // cheia e numele casei (string), valoarea e numarul de puncte (integer)
        //            bufferedWriter.write(entry.getKey() + "#" + entry.getValue() + "\n");

    }
}