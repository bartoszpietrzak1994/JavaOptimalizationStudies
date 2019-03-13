package com.company.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileReader
{
    String read(File file) throws IOException;
    FileReaderType getFileReaderType();
}
