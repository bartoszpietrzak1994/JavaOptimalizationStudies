package com.company.performance;

import com.company.file.PerformanceTestResultToFileExtractor;
import com.company.list.*;
import com.company.model.ListPerformanceTestResult;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ListPerformanceChecker
{
    public void check(int numberOfElements) throws IOException
    {
        List<ListFactory> listFactories = new ArrayList<>();
        listFactories.add(new ArrayListFactory());
        listFactories.add(new LinkedListFactory());
        listFactories.add(new StackFactory());
        listFactories.add(new VectorFactory());

        List<ListPerformanceTestResult> listPerformanceTestResults = new ArrayList<>();
        List<String> performanceTestList = null;
        for (ListFactory listFactory : listFactories)
        {
            performanceTestList = listFactory.provide();
            long startTime, endTime;

            System.out.println(String.format("About to test the performance of list of getType: %s", listFactory.type()));
            System.out.println();
            for (int i = 10; i <= numberOfElements; i*=10)
            {
                ListPerformanceTestResult listPerformanceTestResult = new ListPerformanceTestResult();
                listPerformanceTestResult.setType(listFactory.type());

                listPerformanceTestResult.setNumberOfElements(i);

                addElements(performanceTestList, i);

                System.out.println("Adding element to the beginning of the list");
                startTime = System.nanoTime();
                addElementToTheBeginning(performanceTestList, RandomStringUtils.randomAlphanumeric(15));
                endTime = System.nanoTime();

                listPerformanceTestResult.setAddingToTheBeginningTime(endTime - startTime);

                System.out.println("Adding element to the end of the list");
                startTime = System.nanoTime();
                addElementToTheEnd(performanceTestList, RandomStringUtils.randomAlphanumeric(15));
                endTime = System.nanoTime();

                listPerformanceTestResult.setAddingToTheEndTime(endTime - startTime);

                System.out.println("Adding element at random place to the list");
                startTime = System.nanoTime();
                addElementAtRandomPlace(performanceTestList, RandomStringUtils.randomAlphanumeric(15));
                endTime = System.nanoTime();

                listPerformanceTestResult.setAddingAtRandomPlaceTime(endTime - startTime);

                System.out.println("Removing element from the beginning of the list");
                startTime = System.nanoTime();
                removeElementFromTheBeginning(performanceTestList);
                endTime = System.nanoTime();

                listPerformanceTestResult.setRemovingFromBeginningTime(endTime - startTime);

                System.out.println("Removing element from the end of the list");
                startTime = System.nanoTime();
                removeElementFromTheEnd(performanceTestList);
                endTime = System.nanoTime();

                listPerformanceTestResult.setRemovingFromEndTime(endTime - startTime);

                System.out.println("Removing element at random place to the list");
                startTime = System.nanoTime();
                removeRandomElement(performanceTestList);
                endTime = System.nanoTime();

                listPerformanceTestResult.setRemovingFromRandomPlaceTime(endTime - startTime);

                System.out.println("Browsing list using indexes");
                startTime = System.nanoTime();
                browseUsingIndexes(performanceTestList);
                endTime = System.nanoTime();

                listPerformanceTestResult.setBrowsingWithIndexesTime(endTime - startTime);

                System.out.println("Browsing list using iterator");
                startTime = System.nanoTime();
                iterateThroughList(performanceTestList);
                endTime = System.nanoTime();

                listPerformanceTestResult.setBrowsingWithIteratorTime(endTime - startTime);


                listPerformanceTestResults.add(listPerformanceTestResult);
            }
        }

        PerformanceTestResultToFileExtractor performanceTestResultToFileExtractor = new PerformanceTestResultToFileExtractor();

        for (ListPerformanceTestResult listPerformanceTestResult : listPerformanceTestResults)
        {
            performanceTestResultToFileExtractor.export(listPerformanceTestResult);
        }
    }

    private void addElements(List<String> list, int numberOfElements)
    {
        for (int i = 0; i < numberOfElements; i++)
        {
            list.add(RandomStringUtils.randomAlphanumeric(15));
        }
    }

    private void addElementToTheBeginning(List<String> list, String element)
    {
        list.add(0, element);
    }

    private void addElementToTheEnd(List<String> list, String element)
    {
        list.add(element);
    }

    private void addElementAtRandomPlace(List<String> list, String element)
    {
        list.add(new Random().nextInt(list.size()), element);
    }

    private void removeElementFromTheBeginning(List<String> list)
    {
        list.remove(0);
    }

    private void removeElementFromTheEnd(List<String> list)
    {
        list.remove(list.size() - 1);
    }

    private void removeRandomElement(List<String> list)
    {
        list.remove(new Random().nextInt(list.size() / 2));
    }

    private void browseUsingIndexes(List<String> list)
    {
        String element = "";
        for (int i = 0; i < list.size(); i++)
        {
            element = list.get(i);
        }
    }

    private void iterateThroughList(List<String> list)
    {
        Iterator<String> iterator = list.iterator();

        while(iterator.hasNext())
        {
            iterator.next();
        }
    }
}
