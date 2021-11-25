package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String[] stringArray = {"orange", "blue", "black", "green", "violet", "lilac", "purple"};

        List<String> stringList = new ArrayList<>();

        stringList.addAll(Arrays.asList(stringArray));

        stringList.remove(2);
        stringList.add("white");
        stringList.add(0, "transparent");

        for(String s: stringList) {
            System.out.println(s);
        }

        List<String> colorsSublist = stringList.subList(2,5);

        System.out.println("Color Sublist");
        for(String s: colorsSublist) {
            System.out.println(s);
        }

    }
}



