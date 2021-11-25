package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        String[] text = "Ignore case sensitivity. For example, Apple and apple should be counted as the same word".replaceAll("[^a-zA-Z ]", "").split(" ");

        Set set = new HashSet<>();
        System.out.println("Before removing duplicates: " +text.length);
        for(String t: text) {
            set.add(t.toLowerCase());
        }
        System.out.println("After removing duplicates: " +set.size());

    }
}



