package com.godeltech.module03_pt351_nio;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ObjectIOStreamTest {

    public static void main(String[] args) {

        try {
            ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get("newFile.bin")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
