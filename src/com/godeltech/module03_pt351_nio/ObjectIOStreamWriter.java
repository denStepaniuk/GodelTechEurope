package com.godeltech.module03_pt351_nio;

import com.godeltech.module03_pt344.AnotherPerson;
import com.godeltech.module03_pt344.StreamAPILesson;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Write objects in binary file;
 */
public class ObjectIOStreamWriter {
    private static String fileName = "binaryFile.bin";
    private static String fileNameStream = "binaryFileStream.bin";

    public static void main(String[] args) throws IOException {

        writeObject(fileName, StreamAPILesson.fillPersonsList());
     writeObjectStreamed(fileNameStream, StreamAPILesson.fillPersonsList());
    }

    static void writeObject(String fileName, List<AnotherPerson> list) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));

        for (AnotherPerson person : list) {
            out.writeObject(person);
        }
        out.close();
    }

    static void writeObjectStreamed(String fileName, List<AnotherPerson> list) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));
        list.forEach(obj -> {
            try {
                out.writeObject(obj);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
