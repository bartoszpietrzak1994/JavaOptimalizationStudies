package com.company;

import com.company.creator.RandomBinaryFileCreator;
import com.company.reader.BufferedFileReader;
import com.company.reader.FileReader;
import com.company.reader.MemoryMappedFileReader;
import com.company.reader.NIOFileReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException
    {
        checkReadersPerformance(100000L, "randomBinary");
    }

    private static void checkReadersPerformance(long fileSize, String filePath) throws IOException
    {
        RandomBinaryFileCreator randomBinaryFileCreator = new RandomBinaryFileCreator();
        randomBinaryFileCreator.create(fileSize, filePath);

        List<FileReader> fileReaders = new ArrayList<>();
        fileReaders.add(new BufferedFileReader());
        fileReaders.add(new NIOFileReader());
        fileReaders.add(new MemoryMappedFileReader());

        File file = new File(filePath);
        for (FileReader fileReader : fileReaders)
        {
            System.out.println(fileReader.getFileReaderType().toString());
            System.out.println();

            long startTime = System.nanoTime();
            fileReader.read(file);
            long endTime = System.nanoTime();

            System.out.println(endTime - startTime);
            System.out.println();
        }
    }
}
