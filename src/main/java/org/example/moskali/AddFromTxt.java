package org.example.moskali;

import org.example.Export;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AddFromTxt {
    public static void main(String[] args) {
        ArrayList<String> moskali = new ArrayList<>();
        String text = readTxtFile("moskalili.txt");
      //  System.out.println(text);
        String[] parts = text.split("\\*\\*\\*");
        for (int i = 0; i < parts.length; i++) {
            moskali.add(parts[i]);
            System.out.println(i + parts[i]);
            System.out.println("-------------------------");
        }

        Export.exportArrayList(moskali, "moskal2.dat");
    }

    private static String readTxtFile(String text) {
        try (FileReader reader = new FileReader(text)) {
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
