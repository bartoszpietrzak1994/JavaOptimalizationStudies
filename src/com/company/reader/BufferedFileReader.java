package com.company.reader;

import java.io.*;

public class BufferedFileReader implements FileReader
{
    final static int SIZE = 1024;
    private static final byte[] buffer = new byte[SIZE];

    public void read(File file) throws IOException
    {
        InputStream in = new FileInputStream(file.getAbsolutePath());

        synchronized (buffer) {
            while ((in.read(buffer)) != -1) {}
        }
    }

    @Override
    public FileReaderType getFileReaderType()
    {
        return FileReaderType.BUFFERED;
    }
}
