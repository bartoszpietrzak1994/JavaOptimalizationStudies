package com.company.file;

import com.company.model.PerformanceTestResult;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PerformanceTestResultToFileExtractor
{
    public void export(PerformanceTestResult performanceTestResult) throws IOException
    {
        String filePath = String.format("results/%s_%s", performanceTestResult.getType(), performanceTestResult.getNumberOfElements());

        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(performanceTestResult.toString());
        writer.close();
    }
}
