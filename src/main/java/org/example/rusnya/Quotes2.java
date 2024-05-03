package org.example.rusnya;

import org.example.Export;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Quotes2 {
    public static void main(String[] args) throws IOException {
        Map<Integer, String> originalMap = new HashMap<>();
        ArrayList<String> aneks = new ArrayList<>();
        String url = "https://trip-trial.blogspot.com/2015/01/stshi-o-rossii.html";
        //String element = "//div[@class='shift']";
        var document = Jsoup.connect(url).get();
        var elements = document.selectXpath("//div[@class='shift']");
        var all = document.body();

        try {
            // Записываем HTML-код в файл
            FileWriter writer = new FileWriter("liricsRusnya.html");
            writer.write(document.html());
            writer.close();
            System.out.println("HTML успешно сохранен в файл: " + all);
        } catch (IOException e) {
            System.out.println("all");
        }

            String out = elements.text();
            String result = out.replaceAll("(?=[A-ZА-ЯЁ])", "\n");
            String[] parts = result.split("\\*\\*\\*");

            for (int i = 0; i < parts.length; i++) {
                //if (parts[i].length() > 2)
                    //  System.out.println(parts[i]);
                    //System.out.println(i);
            }

            System.out.println(parts.toString());
            //        for (int i = 0; i < elements.size() ; i++) {
//            System.out.println(elements.get(i).text());
//            System.out.println(elements.get(i).text().length());
//            System.out.println("-------------------------");
//            if (elements.get(i).text().length()>80) {
//                originalMap.put(i,elements.get(i).text());
//                aneks.add(elements.get(i).text());}
//        }
//        Export.exportArrayListToCSV(aneks, "src/rusnya.csv");
//        System.out.println(originalMap.size());
//        Export.exportMapToCSV(originalMap, "src/rusnyaMap.csv");
        }
    }

