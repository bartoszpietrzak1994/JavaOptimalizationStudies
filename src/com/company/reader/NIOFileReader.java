package com.company.reader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOFileReader implements FileReader
{
    public String read(File file) throws IOException
    {
        Path path = Paths.get(file.getAbsolutePath());
        byte[] bytes = Files.readAllBytes(path);

        return new String(bytes);
    }

    @Override
    public FileReaderType getFileReaderType()
    {
        return FileReaderType.NIO;
    }
}
