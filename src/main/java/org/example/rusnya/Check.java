package org.example.rusnya;

import org.example.ImportAnek;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Check {
    public static void main(String[] args) {
        ArrayList<String> all = new ArrayList<>();
      all = ImportAnek.importArrayList("all.dat");

        System.out.println(all.size());
        for (int i = 0; i < all.size(); i++) {

            System.out.println(all.get(i));
            System.out.println("------------=============------------===========-------------");
        }

    }




    public static Map<String, String> importMapFromCSV(String filePath) {
        Map<String, String> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    map.put(parts[0], parts[1]);
                }
            }
            System.out.println("Map успешно импортирован из CSV файла: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
