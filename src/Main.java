import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("punkte.txt");

        // Avem nevoie de un FileReader si un BufferedReader.
        FileReader fileReader = new FileReader(file);
        // bufferedReader il ia pe fileReader ca parametru la constructor
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // citim toate liniile
        bufferedReader.lines()
                // inlocuim fiecare linie cu doar partea cu numele studentului
                .map((line)->line.split("&")[1])
                // eliminam dublurile
                .distinct()
                // le sortam
                .sorted()
                // le printam
                .forEach((line)-> System.out.println(line));
    }
}