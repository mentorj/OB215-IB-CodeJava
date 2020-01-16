package com.javaxpert.trainings.ob215;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.zip.ZipInputStream;

public class DecoratorSample {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("toto.zip");
        ZipInputStream zis = new ZipInputStream(fis);
        BufferedInputStream bis = new BufferedInputStream(zis);
        // SNIP usage des decorations sur le stream
    }
}
