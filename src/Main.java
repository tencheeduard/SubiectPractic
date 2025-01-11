import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("punkte.txt");


        // Avem nevoie de un FileReader si un BufferedReader.
        FileReader fileReader = new FileReader(file);
        // bufferedReader il ia pe fileReader ca parametru la constructor
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // .lines() da un stream cu toate liniile din fisier
        bufferedReader.lines()
                // pentru fiecare linie, o printam
                .forEach( (line) -> System.out.println(line) );


                // mai repede scris ar fi .forEach(System.out::println), unde :: reprezinta o referinta la metoda.
                // dar nu e necesar
    }
}