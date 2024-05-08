package org.example.moskali;

import org.example.Export;
import org.example.ImportAnek;

import java.util.ArrayList;

public class AddNevzorov {
    public static void main(String[] args) {

       ArrayList<String> rusnya ;
       ArrayList<String> nevzorov ;
       ArrayList<String> allprosa = new ArrayList<>();

       nevzorov = ImportAnek.importArrayList("nevzorov.dat");
       rusnya = ImportAnek.importArrayListFromCSV("rusnya.csv");

        for (String s : rusnya
             ) {
            allprosa.add(s);
            System.out.println(s);
            System.out.println("========================");
        }

        for (String s : nevzorov
             ) {
            allprosa.add(s);
            System.out.println(s);
            System.out.println("========================");
        }

        Export.exportArrayList(allprosa, "allprosa.dat");
        Export.exportArrayListToCSV(allprosa, "allprosa.csv");
    }
}
