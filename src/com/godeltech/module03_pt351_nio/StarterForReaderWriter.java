package com.godeltech.module03_pt351_nio;

import com.godeltech.module03_pt344.StreamAPILesson;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * Class use only for engage serialization instances of custom class;
 */
public class StarterForReaderWriter {

    public static void main(String[] args) {

        try {
            ObjectIOStreamWriter.writeObjectStreamed(ObjectIOStreamWriter.getFileNameStream(), StreamAPILesson.fillPersonsList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stream.of(ObjectIOStreamReader
                .readObjects("binaryFileStream.bin"))
                .forEach(System.out::println);
    }

}
