package com.company.creator;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.*;

public class RandomBinaryFileCreator
{
    public void create(long bytes, String filePath) throws IOException
    {
        File file = new File(filePath);
        Writer output = new BufferedWriter(new FileWriter(file, true));

        String randomString;
        StringBuilder binaryString = new StringBuilder();
        byte[] randomStringBytes;

        while(file.length() < bytes) {
            randomString = RandomStringUtils.randomAlphabetic(10000);

            randomStringBytes = randomString.getBytes();

            for (int i = 0; i < randomStringBytes.length; i++) {
                binaryString.append(Integer.toBinaryString(randomStringBytes[i]));
            }

            output.write(binaryString.toString());
        }

        output.close();
    }
}
