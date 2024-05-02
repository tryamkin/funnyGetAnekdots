package org.example;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String... args) throws IOException {

        ArrayList<String> aneks = new ArrayList<>();
        //забираем анекдоты с сайта (указываем страницы)
        aneks =  GetAneks.getAneks(20);

        //экспортируем анекдоты
        String filePath = "arrayListData.dat";
        String filePathCSV = "arrayListData.csv";
        Export.exportArrayList(aneks, filePath);
        Export.exportArrayListToCSV(aneks, filePathCSV);

        //просто скачиваем картинку
        String link = "https://www.zootovary.com/userfiles/435_1.jpg";
        SavePic.savePicFromInet(link);

        ArrayList imported = ImportAnek.importArrayListFromCSV(filePathCSV);
        System.out.println(imported.size());
    }
}