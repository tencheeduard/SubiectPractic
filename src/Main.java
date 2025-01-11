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

        bufferedReader.lines()
                // inlocuieste fiecare linie cu doar ce apare dupa prima &
                .map( (line)->line.split("&")[1] )
                // pastram doar cele care incep cu caracterul dat de la tastatura
                .filter( (name) -> name.startsWith(inputChar) )
                // printam tot ce a ramas
                .forEach( (name) -> System.out.println(name) );
    }
}