package com.company.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileReader implements FileReader
{
    private final static int SIZE = 1024;

    public void read(File file) throws IOException
    {
        FileChannel in = new FileInputStream(file.getAbsolutePath()).getChannel();

        while (in.read(ByteBuffer.allocate(SIZE)) != -1) {}

        in.close();
    }

    @Override
    public FileReaderType getFileReaderType()
    {
        return FileReaderType.NIO;
    }
}
