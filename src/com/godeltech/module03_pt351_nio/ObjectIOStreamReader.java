package com.godeltech.module03_pt351_nio;


import com.godeltech.module03_pt344.AnotherPerson;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class ObjectIOStreamReader {

    public static void main(String[] args) {
        List<AnotherPerson> personList = readObjects("binaryFile.bin");
        personList.forEach(System.out::println);
    }

    static List<AnotherPerson> readObjects(String filename) {
        List<AnotherPerson> list = new LinkedList<>();
        boolean isRun = true;
        try {
            ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(filename)));
            try {
                while (isRun) {
                    AnotherPerson person = (AnotherPerson) in.readObject();
                    if (!"".equals(person.getCountry())) {
                        list.add(person);
                    } else {
                        isRun = false;
                    }
                }
            } catch (ClassNotFoundException e) {
                System.out.println("File " + filename + " don't exist!");
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}
