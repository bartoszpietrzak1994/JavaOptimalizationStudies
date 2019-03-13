package com.company.performance;

import com.company.file.PerformanceTestResultToFileExtractor;
import com.company.model.SetPerformanceTestResult;
import com.company.set.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetsPerformanceChecker
{
    public void check(int numberOfElements) throws IOException
    {
        List<SetFactory> setFactories = new ArrayList<>();
        setFactories.add(new CopyOnWriteArraySetFactory());
        setFactories.add(new HashSetFactory());
        setFactories.add(new LinkedHashSetFactory());
        setFactories.add(new TreeSetFactory());

        List<SetPerformanceTestResult> setPerformanceTestResults = new ArrayList<>();
        Set<String> performanceTestSet = null;
        for (SetFactory setFactory : setFactories)
        {
            performanceTestSet = setFactory.provide();
            String elementToBeFound = "";
            long startTime, endTime;

            System.out.println(String.format("About to test the performance of set of getType: %s", setFactory.type()));
            System.out.println();
            for (int i = 10; i <= numberOfElements; i*=10)
            {
                SetPerformanceTestResult setPerformanceTestResult = new SetPerformanceTestResult();
                setPerformanceTestResult.setType(setFactory.type());

                setPerformanceTestResult.setNumberOfElements(i);

                System.out.println(String.format("Adding %s elements", i));
                startTime = System.nanoTime();
                addElements(performanceTestSet, i);
                endTime = System.nanoTime();

                setPerformanceTestResult.setAddingTime(endTime - startTime);

                System.out.println(String.format("Browsing %s elements", i));

                startTime = System.nanoTime();
                iterateThroughSet(performanceTestSet);
                endTime = System.nanoTime();

                setPerformanceTestResult.setBrowsingTime(endTime - startTime);

                elementToBeFound = RandomStringUtils.randomAlphanumeric(15);
                System.out.println(String.format(
                        "Finding an element with name %s in a set with %s elements",
                        elementToBeFound,
                        i)
                );

                startTime = System.nanoTime();

                doesElementExistOnSet(performanceTestSet, elementToBeFound);
                endTime = System.nanoTime();

                setPerformanceTestResult.setCheckingIfElementExistsTime(endTime - startTime);

                System.out.println(String.format("Removing %s elements", i));
                startTime = System.nanoTime();
                clearSet(performanceTestSet);
                endTime = System.nanoTime();

                setPerformanceTestResult.setRemovingTime(endTime - startTime);

                setPerformanceTestResults.add(setPerformanceTestResult);
            }
        }

        PerformanceTestResultToFileExtractor performanceTestResultToFileExtractor = new PerformanceTestResultToFileExtractor();

        for (SetPerformanceTestResult setPerformanceTestResult : setPerformanceTestResults)
        {
            performanceTestResultToFileExtractor.export(setPerformanceTestResult);
        }
    }

    private void addElements(Set<String> set, int numberOfElements)
    {
        for (int i = 0; i < numberOfElements; i++)
        {
            set.add(RandomStringUtils.randomAlphanumeric(15));
        }
    }

    private void clearSet(Set<String> set)
    {
        set.clear();
    }

    private void iterateThroughSet(Set<String> set)
    {
        Iterator<String> iterator = set.iterator();

        while(iterator.hasNext())
        {
            iterator.next();
        }
    }

    private boolean doesElementExistOnSet(Set<String> set, String element)
    {
        return set.contains(element);
    }
}
