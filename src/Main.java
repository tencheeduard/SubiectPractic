import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("punkte.txt");


        // Avem nevoie de un FileReader si un BufferedReader.
        FileReader fileReader = new FileReader(file);
        // bufferedReader il ia pe fileReader ca parametru la constructor
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // citim prima linie
        String line = bufferedReader.readLine();
        while(line != null)
        {
            System.out.println(line);

            // citim urmatoarea linie
            line = bufferedReader.readLine();
        }
    }
}