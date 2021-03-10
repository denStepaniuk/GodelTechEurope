package com.godeltech.module03_pt351_nio;

import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 *Try work with File class, readers/writers;
 */

public class IOClassTest {
    private static final File FOLDER_CREATOR = new File("c:\\someFolder");                    //declare and initialise folder name;
    private static final File CREATE_FILE = new File(FOLDER_CREATOR + "\\someFile.txt");       //declare and initialise file name;

    public static void main(String[] args) throws IOException, InterruptedException {
        FOLDER_CREATOR.mkdir();                                                      //create this ^ folder;
        CREATE_FILE.createNewFile();                                                  //create this ^ file;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FOLDER_CREATOR + "\\someNewFile.txt"));
             BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\d.stsepaniuk\\IdeaProjects\\GodelTechEurope\\src\\com\\godeltech\\module03_pt344\\Hrodna.txt"))) {
            while (reader.readLine() != null) {
                writer.write(reader.readLine() + "\n");
            }
        }

        System.out.println("File create at directory: " + FOLDER_CREATOR.getPath() +"\nWith name: " + CREATE_FILE.getName());
        TimeUnit.SECONDS.sleep(15);
        CREATE_FILE.delete();                                                        //delete created file;
        FOLDER_CREATOR.delete();                                                     //delete created folder;

    }

}

