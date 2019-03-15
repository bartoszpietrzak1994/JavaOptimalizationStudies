package com.company.model;

import com.company.queue.QueueType;

public class QueuePerformanceTestResult implements PerformanceTestResult
{
    private QueueType queueType;
    private int numberOfElements;
    private long addingToTheEndTime;
    private long removingFromEndTime;
    private long browsingWithIteratorTime;

    @Override
    public String getType()
    {
        return this.queueType.toString();
    }

    public void setType(QueueType queueType)
    {
        this.queueType = queueType;
    }

    @Override
    public int getNumberOfElements()
    {
        return this.numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements)
    {
        this.numberOfElements = numberOfElements;
    }

    public void setAddingToTheEndTime(long addingToTheEndTime)
    {
        this.addingToTheEndTime = addingToTheEndTime;
    }

    public void setRemovingFromEndTime(long removingFromEndTime)
    {
        this.removingFromEndTime = removingFromEndTime;
    }

    public void setBrowsingWithIteratorTime(long browsingWithIteratorTime)
    {
        this.browsingWithIteratorTime = browsingWithIteratorTime;
    }

    public String toString()
    {
        return String.format("Queue getType: %s,\nnumber of elements: %s,\n" +
                        "time of adding item to the end: %s,\n" +
                        "time of removing item from the end: %s,\n" +
                        "browsing using iterator: %s\n",
                queueType,
                numberOfElements,
                addingToTheEndTime,
                removingFromEndTime,
                browsingWithIteratorTime
        );
    }
}
