package org.example;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public  class GetAneks {

    public static ArrayList  getAneks (int pages) throws IOException {
        Map<Integer, String> anekMap = new HashMap<>();
        ArrayList<String> aneks = new ArrayList<>();
        String url = "https://anekdotov.net/anekdot/index-page-";
        for (int i = 2; i < pages; i++) {
            var document = Jsoup.connect(url + i + ".html").get();
            var elements = document.selectXpath("//*[@class=\"anekdot\"]");
            for (int j = 0; j < elements.size(); j++) {
                aneks.add(document.selectXpath("(//div[@class='anekdot'])[" + j + "]").text());
            }
        }
        for (String s : aneks) {
            System.out.println(s);
            System.out.println("----------===============-----------");
        }
        System.out.println(aneks.size());
        return aneks;
    }

}
