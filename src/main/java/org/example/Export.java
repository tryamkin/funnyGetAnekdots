package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
}
