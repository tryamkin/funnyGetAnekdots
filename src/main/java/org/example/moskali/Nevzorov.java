package org.example.moskali;

import org.example.Export;
import org.jsoup.Jsoup;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Nevzorov {

    public static void main(String[] args) throws IOException {
        ArrayList<String> nevzorov = new ArrayList<>();
        String text = readTxtFile("nevzorov.txt");
        //  System.out.println(text);
        String[] parts = text.split("\\n\\s*\\n");

        for (int i = 0; i <parts.length ; i++) {
            nevzorov.add(parts[i] + "\n  - Александр Невзоров");
        }
        for (String s: nevzorov
             ) {
            System.out.println(s);
            System.out.println("===================================");
        }
        Export.exportArrayList(nevzorov,"nevzorov.dat");
        Export.exportArrayListToCSV(nevzorov, "nevzorov.csv");

       }

    public static String readTxtFile( String name) {
        String  text = "";
        try (FileReader reader = new FileReader(name)) {
            StringBuilder stringBuilder = new StringBuilder();
            int character;
            while ((character = reader.read()) != -1) {
                stringBuilder.append((char) character);
            }
          text = stringBuilder.toString();
            System.out.println("Прочитанная строка из файла: ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

}
