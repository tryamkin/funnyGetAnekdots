package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String... args) throws IOException {
        Map<Integer, String> anekMap = new HashMap<>();
        ArrayList<String> aneks = new ArrayList<>();
        //забираем анекдоты с сайта (указываем страницы)
         aneks =  GetAneks.getAneks(20);

        for (int i = 0; i <aneks.size(); i++) {
            anekMap.put(i,aneks.get(i));
        }

        //экспортируем анекдоты
        String filePath = "arrayListData.dat";
        String filePathCSV = "arrayListData.csv";
        String filePathCSVMap = "anekMap.csv";
        Export.exportArrayList(aneks, filePath);
        Export.exportArrayListToCSV(aneks, filePathCSV);
        Export.exportMapToCSV(anekMap,filePathCSVMap);
        //просто скачиваем картинку
        String link = "https://www.zootovary.com/userfiles/435_1.jpg";
        SavePic.savePicFromInet(link);

        ArrayList imported = ImportAnek.importArrayListFromCSV(filePathCSV);
        System.out.println(imported.size());
    }
}