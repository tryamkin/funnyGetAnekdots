package org.example.rusnya;

import org.example.Export;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Quotes {

    public static void main(String[] args) throws IOException {
        Map<Integer, String> originalMap = new HashMap<>();
        ArrayList<String> aneks = new ArrayList<>();
        String url = "https://trip-trial.blogspot.com/2014/03/Citaty-i-aforizmy-o-russkih.html";
        String element = "//*[@style=\"text-align: justify;\"]";

        var document = Jsoup.connect(url).get();
        var elements = document.selectXpath("//*[@style=\"text-align: justify;\"]");
        for (int i = 0; i < elements.size() ; i++) {
            System.out.println(elements.get(i).text());
            System.out.println(elements.get(i).text().length());
            System.out.println("-------------------------");
            if (elements.get(i).text().length()>80) {
                originalMap.put(i,elements.get(i).text());
                aneks.add(elements.get(i).text());}
        }
        Export.exportArrayListToCSV(aneks, "src/rusnya.csv");
        System.out.println(originalMap.size());
        Export.exportMapToCSV(originalMap, "src/rusnyaMap.csv");
    }

    }

