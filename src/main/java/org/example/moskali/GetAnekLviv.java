package org.example.moskali;

import org.example.Export;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;

public class GetAnekLviv {
    public static void main(String[] args) throws IOException {

        String element =  "//*[@class=\"hoveranek black\"]";
        String url =  "https://rozdil.lviv.ua/anekdot/search/24/index.php?p=38";
      //  var document = Jsoup.connect(url).get();
       // var elements = document.selectXpath(element);
        ArrayList<String> moskal = new ArrayList<>();

        for (int j = 1; j < 39; j++) {
            var documents = Jsoup.connect("https://rozdil.lviv.ua/anekdot/search/24/index.php?p="+j).get();
            var elements = documents.selectXpath(element);
                  for (int i = 0; i <elements.size() ; i++) {
                      moskal.add(elements.text()+ "\n");
                      }

        }


        Export.exportArrayListToCSV(moskal, "try1.csv");
        System.out.println(moskal.size());

    }

    private static void getAneksToAray(String path, String url1, ArrayList<String> moskal) throws IOException {
        var document = Jsoup.connect(url1).get();
        var elements = document.selectXpath(path);
        for (int j = 0; j < elements.size(); j++) {
            moskal.add(document.selectXpath("//*[@id=\"dle-content\"]/div[" +j + "]/p").text() +"\n");
        }
    }
}
