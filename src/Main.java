import java.awt.image.ImageProducer;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("punkte.txt");

        // Avem nevoie de un FileReader si un BufferedReader.
        FileReader fileReader = new FileReader(file);
        // bufferedReader il ia pe fileReader ca parametru la constructor
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        Map<String, Integer> dictionary = bufferedReader.lines()
                // impartim liniile
                .map((line) -> line.split("&"))

                // collect poate transforma un stream intr-un alt fel de colectie, de data asta in map.
                .collect(Collectors.toMap(
                        // intai ii spunem functia pe care o foloseste ca sa seteze cheia.
                        (line)->line[2], // alegem doar numele casei

                        // apoi ii spunem functia pe care o foloseste ca sa seteze valoarea
                        (line)->Integer.valueOf(line[4]), // alegem doar numarul de puncte

                        // apoi ii putem spune ce sa faca in caz ca cheile sunt egale (adica daca intalneste a doua oara in fisier acelasi nume de casa)
                        (a,b)->a+b // in cazul asta, vrem sa adauge numerele de puncte, ca sa gasim totalul.
                ));


        // facem si aici o lista separata care contine casele in ordine descrescatoare dupa puncte.
        List<String> sortedHouseList = dictionary.keySet().stream()

                // folosim metoda de .sorted(), la care ii zicem sa compare dupa valoarea (punctele) din dictionar.
                // pentru comparatie poti folosi .compareTo(), care exista pentru aproape orice tip de date (String, Float, Integer etc.)

                // daca vrei sa inversezi ordinea (crescator, descrescator), doar schimbi din care dintre ele (house1 sau house2) apelezi metoda de .compareTo().
                // deci daca vrei aici sa fie crescator, ai face dictionary.get(house1).compareTo(dictionary.get(house2)).
                .sorted( (house1, house2) -> dictionary.get(house2).compareTo(dictionary.get(house1)) ).toList();



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

    }
}