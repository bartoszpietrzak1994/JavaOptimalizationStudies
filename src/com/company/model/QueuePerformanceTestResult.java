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

    public long getAddingToTheEndTime()
    {
        return addingToTheEndTime;
    }

    public void setAddingToTheEndTime(long addingToTheEndTime)
    {
        this.addingToTheEndTime = addingToTheEndTime;
    }

    public long getRemovingFromEndTime()
    {
        return removingFromEndTime;
    }

    public void setRemovingFromEndTime(long removingFromEndTime)
    {
        this.removingFromEndTime = removingFromEndTime;
    }

    public long getBrowsingWithIteratorTime()
    {
        return browsingWithIteratorTime;
    }

    public void setBrowsingWithIteratorTime(long browsingWithIteratorTime)
    {
        this.browsingWithIteratorTime = browsingWithIteratorTime;
    }

    public String toString()
    {
        return String.format("List getType: %s, number of elements: %s, " +
                        "time of adding item to the end: %s, " +
                        "time of removing item from the end: %s, " +
                        "browsing using iterator: %s",
                queueType,
                numberOfElements,
                addingToTheEndTime,
                removingFromEndTime,
                browsingWithIteratorTime
        );
    }
}
