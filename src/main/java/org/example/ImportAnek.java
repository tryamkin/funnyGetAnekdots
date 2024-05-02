package org.example;

import java.io.*;
import java.util.ArrayList;

public class ImportAnek {

    public static ArrayList<String> importArrayList(String filePath) {
        ArrayList<String> arrayList = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            arrayList = (ArrayList<String>) inputStream.readObject();
            System.out.println("ArrayList успешно импортирован из " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static ArrayList<String> importArrayListFromCSV(String filePath) {
        ArrayList<String> arrayList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                arrayList.add(line);
            }
            System.out.println("ArrayList успешно импортирован из CSV файла: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
