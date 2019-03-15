package com.company.performance;

import com.company.file.PerformanceTestResultToFileExtractor;
import com.company.model.QueuePerformanceTestResult;
import com.company.queue.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class QueuePerformanceChecker
{
    public void check(int numberOfElements) throws IOException
    {
        List<QueueFactory> queueFactories = new ArrayList<>();
        queueFactories.add(new ArrayBlockingQueueFactory());
        queueFactories.add(new LinkedBlockingQueueFactory());
        queueFactories.add(new LinkedTransferQueueFactory());
        queueFactories.add(new PriorityBlockingQueueFactory());
        queueFactories.add(new PriorityQueueFactory());

        List<QueuePerformanceTestResult> queuePerformanceTestResults = new ArrayList<>();
        Queue<String> performanceTestQueue = null;
        for (QueueFactory queueFactory : queueFactories)
        {
            for (int i = 10; i <= numberOfElements; i*=10)
            {
                performanceTestQueue = queueFactory.provide(i);
                long startTime, endTime;

                System.out.println(String.format("About to test the performance of list of getType: %s", queueFactory.type()));
                System.out.println();

                QueuePerformanceTestResult queuePerformanceTestResult = new QueuePerformanceTestResult();
                queuePerformanceTestResult.setType(queueFactory.type());

                queuePerformanceTestResult.setNumberOfElements(i);

                addElements(performanceTestQueue, i-1);

                System.out.println("Adding element to the end of the list");
                startTime = System.nanoTime();
                addElementToTheEnd(performanceTestQueue, RandomStringUtils.randomAlphanumeric(15));
                endTime = System.nanoTime();

                queuePerformanceTestResult.setAddingToTheEndTime(endTime - startTime);

                System.out.println("Removing element from the end of the list");
                startTime = System.nanoTime();
                removeElementFromTheEnd(performanceTestQueue);
                endTime = System.nanoTime();

                queuePerformanceTestResult.setRemovingFromEndTime(endTime - startTime);

                System.out.println("Browsing list using iterator");
                startTime = System.nanoTime();
                iterateThroughQueue(performanceTestQueue);
                endTime = System.nanoTime();

                queuePerformanceTestResult.setBrowsingWithIteratorTime(endTime - startTime);


                queuePerformanceTestResults.add(queuePerformanceTestResult);
            }
        }

        PerformanceTestResultToFileExtractor performanceTestResultToFileExtractor = new PerformanceTestResultToFileExtractor();

        for (QueuePerformanceTestResult queuePerformanceTestResult : queuePerformanceTestResults)
        {
            performanceTestResultToFileExtractor.export(queuePerformanceTestResult);
        }
    }

    private void addElements(Queue<String> queue, int numberOfElements)
    {
        for (int i = 0; i < numberOfElements; i++)
        {
            queue.add(RandomStringUtils.randomAlphanumeric(15));
        }
    }


    private void addElementToTheEnd(Queue<String> queue, String element)
    {
        queue.add(element);
    }

    private void removeElementFromTheEnd(Queue<String> queue)
    {
        queue.poll();
    }

    private void iterateThroughQueue(Queue<String> queue)
    {
        Iterator<String> iterator = queue.iterator();

        while(iterator.hasNext())
        {
            iterator.next();
        }
    }
}
