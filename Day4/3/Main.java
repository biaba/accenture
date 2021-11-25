package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Please write a sentence and press enter");
        Scanner in = new Scanner(System.in);

        String text = in.nextLine();

        System.out.println("Write a file name without extension where to save your sentence");

        String fileName = in.nextLine() +".txt";


        FileOutputStream output = null;

        try {
            output = new FileOutputStream(fileName);
            output.write(text.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



