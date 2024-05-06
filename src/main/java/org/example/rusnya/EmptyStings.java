package org.example.rusnya;

import org.example.Export;
import org.example.ImportAnek;

import java.util.ArrayList;

public class EmptyStings {

    public static void main(String[] args) {
        ArrayList<String> all = new ArrayList<>();
        all = ImportAnek.importArrayList("all.dat");

        int f = all.size();
        System.out.println(all.size());

        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).length()<2){
                System.out.println(i);
        //        System.out.println(all.get(i));
                all.remove(i);
            }
        }

        System.out.println( all.size());
        System.out.println(f - all.size());
        Export.exportArrayList(all, "all.dat");
    }



}
