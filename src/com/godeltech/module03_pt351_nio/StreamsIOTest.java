package com.godeltech.module03_pt351_nio;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class StreamsIOTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        File folderCreator = new File("c:\\someFolder");                    //declare and initialise folder name;
        folderCreator.mkdir();                                                      //create this ^ folder;
        File createFile = new File(folderCreator + "\\someFile.txt");       //declare and initialise file name;
        createFile.createNewFile();                                                  //create this ^ file;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(folderCreator + "\\someNewFile.txt"));
             BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\d.stsepaniuk\\IdeaProjects\\GodelTechEurope\\src\\com\\godeltech\\module03_pt344\\Hrodna.txt"))) {
            while (reader.readLine() != null) {
                writer.write(reader.readLine() + "\n");
            }
        }

        TimeUnit.SECONDS.sleep(60);
        createFile.delete();                                                        //delete created file;
        folderCreator.delete();                                                     //delete created folder;

    }

}

