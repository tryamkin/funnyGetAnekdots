package org.example.rusnya;

import org.example.Export;
import org.example.ImportAnek;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HalfFinal {
    public static void main(String[] args) throws IOException {
        Map<Integer, String> originalMap = new HashMap<>();
        ArrayList<String> all = new ArrayList<>();
        ArrayList<String> prosa = new ArrayList<>();
        ArrayList<String> lyrics = new ArrayList<>();
        prosa = ImportAnek.importArrayListFromCSV("rusnya.csv");
        String text = "";
        text = readTxtFile(text);
     //   String result = text.replaceAll("(?=[A-ZА-ЯЁ])", "\n");
        String[] parts = text.split("\\*\\*\\*");
        for (int i = 0; i < parts.length; i++) {
            lyrics.add(parts[i]);
            originalMap.put(i, parts[i]);
        //    System.out.println(i + parts[i]);
          //  System.out.println("-------------------------");
        }

        for (int i = 0; i <lyrics.size() ; i++) {
            all.add(lyrics.get(i));
          //  System.out.println(lyrics.get(i));
          //  System.out.println("-------------------------");
        }

        for (int i = 0; i < prosa.size(); i++) {
            all.add(prosa.get(i));
        }

        for (int i = 0; i < all.size() ; i++) {
            originalMap.put(i, all.get(i));
            System.out.println(all.get(i));
            System.out.println("--------------------------------------------------------------");
        }

        System.out.println(lyrics.size() + " size");
        System.out.println(prosa.size() +  " size" );
        System.out.println(all.size() +  " size" );
        Export.exportMapToCSV(originalMap, "ryasnyaAllMap.csv");
        Export.exportArrayListToCSV(all, "ryasnyaAll.csv");
        Export.exportArrayList(all, "all.dat");
    }




    private static String readTxtFile(String text) {
        try (FileReader reader = new FileReader("outSpace.txt")) {
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

    public static void writeTxt(String pathAndName, String file) throws IOException {
        try {
            FileWriter writer = new FileWriter(pathAndName);
            writer.write(file);
            System.out.println("Строка успешно записана в файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


