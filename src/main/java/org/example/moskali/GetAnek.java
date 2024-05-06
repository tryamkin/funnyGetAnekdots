package org.example.moskali;

import org.example.Export;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;

public class GetAnek {



    public static void main(String[] args) throws IOException {
        String path = "//*[@id=\"dle-content\"]/*/p";
        String url3 = "https://anekdot.kozaku.in.ua/pro_moskaliv/page/3/";
        String url2 = "https://anekdot.kozaku.in.ua/pro_moskaliv/page/2/";
        String url1 = "https://anekdot.kozaku.in.ua/pro_moskaliv/page/1/";
        ArrayList<String> moskal = new ArrayList<>();
        getAneksToAray(path, url1, moskal);
        getAneksToAray(path, url2, moskal);
        getAneksToAray(path, url3, moskal);
        System.out.println(moskal.size());
        for (String s : moskal) {
            System.out.println(s);
        }
        Export.exportArrayList(moskal, "moskal.dat");

    }

    private static void getAneksToAray(String path, String url1, ArrayList<String> moskal) throws IOException {
        var document = Jsoup.connect(url1).get();
        var elements = document.selectXpath(path);
        for (int j = 0; j < elements.size(); j++) {
            moskal.add(document.selectXpath("//*[@id=\"dle-content\"]/div[" +j + "]/p").text() +"\n");
        }
    }
}
