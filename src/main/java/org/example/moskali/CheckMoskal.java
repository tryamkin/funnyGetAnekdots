package org.example.moskali;

import org.example.Export;
import org.example.ImportAnek;

import java.util.ArrayList;

public class CheckMoskal {
    public static void main(String[] args) {

        ArrayList<String> concat = new ArrayList();
        ArrayList<String> moskalall = new ArrayList();
        ArrayList<String> alllist = new ArrayList();
        moskalall = ImportAnek.importArrayList("moskalall.dat");
        alllist = ImportAnek.importArrayList("all.dat");

        for (String s : moskalall) {
            concat.add(s);
        }

        for (String s : alllist) {
            concat.add(s);
        }


        System.out.println(concat.size());
        for (String s : concat) {
            System.out.println(s);
            System.out.println("------------------");
        }
        Export.exportArrayList(concat, "all1.dat");
    }
}
