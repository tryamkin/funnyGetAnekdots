package org.example.rusnya;

import org.example.Export;
import org.example.ImportAnek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddLyricsAndProsa {
    static ArrayList<String> prosa = new ArrayList<>();
    static ArrayList<String> lyrycs = new ArrayList<>();
    static ArrayList<String> all = new ArrayList<>();
    static Map<Integer, String> originalMap = new HashMap<>();
    public static void main(String[] args) {

       importLists();
       getAll();
        for (int i = 0; i < all.size(); i++) {
            originalMap.put(i, all.get(i));
        }

        Export.exportMapToCSV(originalMap, "ryasnyaAllMap.csv");
        Export.exportArrayListToCSV(all, "ryasnyaAll.csv");
    }


    public static void importLists(){
        lyrycs =  ImportAnek.importArrayListFromCSV("lyrics.csv");
        prosa =  ImportAnek.importArrayListFromCSV("rusnya.csv");
    }

    public static ArrayList<String> getAll() {
        for (int i = 0; i < prosa.size() ; i++) {
            all.add(prosa.get(i));
        }
        System.out.println(all.size() + " prosa");
        for (int i = 0; i <lyrycs.size() ; i++) {
            all.add(lyrycs.get(i));
        }
        System.out.println(all.size());
        return all;
    }
}
