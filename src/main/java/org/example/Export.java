package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Export {

    public static void exportArrayList(ArrayList<String> arrayList, String filePath) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(arrayList);
            System.out.println("ArrayList успешно экспортирован в " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exportArrayListToCSV(List<String> arrayList, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String element : arrayList) {
                writer.write(element);
                writer.newLine();
            }
            System.out.println("ArrayList успешно экспортирован в CSV файл: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Метод для экспорта Map в файл CSV
    public static void exportMapToCSV(Map<Integer, String> map, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
            System.out.println("Map успешно экспортирован в CSV файл: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
