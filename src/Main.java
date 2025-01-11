import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("punkte.txt");


        // Folosim scanner pentru input de la tastatura
        Scanner input = new Scanner(System.in);

        // luam primul caracter din string-ul de input si il memoram
        String inputChar = input.next();

        // Avem nevoie de un FileReader si un BufferedReader.
        FileReader fileReader = new FileReader(file);
        // bufferedReader il ia pe fileReader ca parametru la constructor
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // citim prima linie
        String line = bufferedReader.readLine();
        while(line != null)
        {
            // impartim linia la fiecare &
            String[] entries = line.split("&");

            // daca incepe numele cu caracterul dat de la tastatura, il printam
            if(entries[1].startsWith(inputChar))
                System.out.println(entries[1]);

            // citim urmatoarea linie
            line = bufferedReader.readLine();
        }
    }
}