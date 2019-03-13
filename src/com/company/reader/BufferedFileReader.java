package com.company.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class BufferedFileReader implements FileReader
{
    public String read(File file) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file.getAbsolutePath()));

        StringBuffer stringBuffer = new StringBuffer();
        String line = null;

        while((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line);
        }

        bufferedReader.close();

        return stringBuffer.toString();
    }

    @Override
    public FileReaderType getFileReaderType()
    {
        return FileReaderType.BUFFERED;
    }
}
