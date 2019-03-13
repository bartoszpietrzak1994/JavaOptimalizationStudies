package com.company.reader;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MemoryMappedFileReader implements FileReader
{
    @Override
    public String read(File file) throws IOException
    {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");

        FileChannel fileChannel = randomAccessFile.getChannel();

        MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < buffer.limit(); i++)
        {
            stringBuilder.append(buffer.get());
        }

        return stringBuilder.toString();
    }

    @Override
    public FileReaderType getFileReaderType()
    {
        return FileReaderType.MEMORY_MAPPED;
    }
}
