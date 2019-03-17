package com.company.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MemoryMappedFileReader implements FileReader
{
    @Override
    public void read(File file) throws IOException
    {
        FileChannel fileChannel = new FileInputStream(file).getChannel();
        MappedByteBuffer mappedByteBuffer = new RandomAccessFile(file, "r")
                .getChannel()
                .map(FileChannel.MapMode.READ_ONLY, 0, file.length());

        while(mappedByteBuffer.hasRemaining()) {
            mappedByteBuffer.get();
        }

        fileChannel.close();
    }

    @Override
    public FileReaderType getFileReaderType()
    {
        return FileReaderType.MEMORY_MAPPED;
    }
}
