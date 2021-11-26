package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Colors {

    private String[] stringArray = new String[7];
    List<String> stringList = new ArrayList<>();

    public Colors(String[] colorsUpToSeven) {
        this.stringArray = colorsUpToSeven;
        //{"orange", "blue", "black", "green", "violet", "lilac", "purple"};
    }

    public List<String> turnArrayIntoList() {
        this.stringList.addAll(Arrays.asList(stringArray));
        return stringList;
    }

    public List<String> getList() {
        return this.stringList;
    }

    public void addColor(String color) {
        this.stringList.add(color);
    }

    public void addColorAtIndex(int position, String color) {
        stringList.add(position, color);
    }

    public void removeColor(String color) {
        stringList.remove(color);
    }

    public void removeFirst() {
        stringList.remove(0);
    }

    public void printOutList() {
        for(String s: stringList) {
            System.out.println(s);
        }
    }

    public List<String> createSublist(int startIndex, int endIndex) {
        return stringList.subList(startIndex, endIndex);
    }
}
