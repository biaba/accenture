package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

       // 1
        File f = new File("C:\\Users\\baiba\\IdeaProjects\\accenture");
        String[] fileList = f.list();

        for(String s: fileList){
            System.out.println(s);
        }

        // 2
        File f2 = new File("C:\\Users\\baiba\\IdeaProjects");
        String[] fileListTxt = f2.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });

        for(String s: fileListTxt){
            System.out.println(s);
        }

        // 3
        File f3 = new File("C:\\Users\\baiba\\IdeaProjects\\Birch.txt");
        if(f3.exists() && !f3.isDirectory()) {
            System.out.println("The file exists");
        }

        // 4
        if(f3.canRead()){
            System.out.println("Can read");
        }
        if(f3.canWrite()) {
            System.out.println("Can write");
        }
        if(!f3.canRead() && !f3.canWrite()) {
            System.out.println("Neither reading nor writing is allowed");
        }

        // 5
        System.out.println(f3.getAbsolutePath() + " is directory: "+ f3.isDirectory()+ ". Is file: "+ f3.isFile());

        // 6
        File f6 = new File("C:\\Users\\baiba\\IdeaProjects\\Oak.txt");
        System.out.println("Which file is lexicographically first? "+ (f6.compareTo(f3)<0? f6: (f6.compareTo(f3)==0?"both are equal: "+f3 +" "+f6 :f3)));

 // NO       // 7
        File f7 = new File("C:\\Users\\baiba\\IdeaProjects\\AshTree.doc");
        Date date=new Date(f7.lastModified());
        System.out.println("File "+f7.toString().substring(f7.toString().lastIndexOf("\\")+1,f7.toString().length())+" was last modified: "+date);

        // 8
        System.out.println(" Please enter something. Really anything");
        Scanner scanner = new Scanner(System.in);
        String something = scanner.next();
        System.out.println("Thank you for entering "+something);

   // NO     // 9
        System.out.println("File size in bytes of: "+ f7+" is: "+f7.length()+ " or KB: "+f7.length()/1024+ " or MB: " +f7.length()/(1024*1024));

        // 10
        FileInputStream input = new FileInputStream("newFile.txt");
        byte[] byteArray = input.readAllBytes();
        String st = new String(byteArray);
        System.out.println(st);
        input.close();

        // 11
        BufferedReader bReader = new BufferedReader(new FileReader("newFile.txt"));

        String readLine = bReader.readLine();

        while(readLine!=null){
            System.out.println(readLine);
            readLine = bReader.readLine();
        }
        bReader.close();

        // 12

        // the same

        // 13
        BufferedReader bReader13 = new BufferedReader(new FileReader("newFile.txt"));

        String readLine13 = bReader13.readLine();
        String newVariable = "";

        while(readLine13!=null){
            newVariable+= newVariable.length()!=0?" ":"";
            newVariable+=readLine13;
            readLine13 = bReader13.readLine();
        }
        System.out.println("Now it's written into a new Variable: "+newVariable);
        bReader13.close();

        // 14
        BufferedReader bReader14 = new BufferedReader(new FileReader("newFile.txt"));

        String readLine14 = bReader14.readLine();
        String newVariable14 = "";

        while(readLine14!=null){
            newVariable14+= newVariable.length()!=0?" ":"";
            newVariable14+=readLine14;
            readLine14 = bReader14.readLine();
        }
        String[] arr = newVariable14.split(" ");

        System.out.println("Now it's written into a Array:");
        for(String s: arr) {
            System.out.println(s);
        }
        bReader14.close();

        // 15
        FileInputStream input15 = new FileInputStream("Oak.txt");
        FileOutputStream output15 = new FileOutputStream("BabyOak.txt");

        output15.write(input15.readAllBytes());
        input15.close();
        output15.close();

        // 16
        File file16 = new File("Oak.txt");
        FileWriter fr16 = new FileWriter(file16, true);
        fr16.write("Around around");
        fr16.close();

        // 17
        BufferedReader bReader17 = new BufferedReader(new FileReader("news.txt"));

        String readLine17 = bReader17.readLine();
        int counter = 1;

        while(counter<4){
            System.out.println(readLine17);
            readLine17 = bReader17.readLine();
            counter++;
        }
        bReader17.close();

        // 18
        BufferedReader bReader18 = new BufferedReader(new FileReader("news.txt"));

        String readLine18 = bReader18.readLine();
        String newVariable18 = "";

        while(readLine18!=null){
            newVariable18+= newVariable.length()!=0?" ":"";
            newVariable18+=readLine18;
            readLine18 = bReader18.readLine();
        }

        String[] arr18 = newVariable18.split(" ");
        String longest ="";
        for(String s: arr18) {
            if(s.length()>longest.length()){
                longest=s;
            }
        }
        System.out.println("The longes word in the file is: "+ longest);
        bReader18.close();

    }
}



