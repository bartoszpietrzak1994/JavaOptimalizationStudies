package com.company.model;

import com.company.list.ListType;

public class ListPerformanceTestResult implements PerformanceTestResult
{
    private ListType listType;
    private int numberOfElements;
    private long addingToTheBeginningTime;
    private long addingToTheEndTime;
    private long addingAtRandomPlaceTime;
    private long removingFromBeginningTime;
    private long removingFromEndTime;
    private long removingFromRandomPlaceTime;
    private long browsingWithIndexesTime;
    private long browsingWithIteratorTime;

    public String getType()
    {
        return listType.toString();
    }

    public void setType(ListType listType)
    {
        this.listType = listType;
    }

    public int getNumberOfElements()
    {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements)
    {
        this.numberOfElements = numberOfElements;
    }

    public void setAddingToTheBeginningTime(long addingToTheBeginningTime)
    {
        this.addingToTheBeginningTime = addingToTheBeginningTime;
    }

    public void setAddingToTheEndTime(long addingToTheEndTime)
    {
        this.addingToTheEndTime = addingToTheEndTime;
    }

    public void setAddingAtRandomPlaceTime(long addingAtRandomPlaceTime)
    {
        this.addingAtRandomPlaceTime = addingAtRandomPlaceTime;
    }

    public void setRemovingFromBeginningTime(long removingFromBeginningTime)
    {
        this.removingFromBeginningTime = removingFromBeginningTime;
    }

    public void setRemovingFromEndTime(long removingFromEndTime)
    {
        this.removingFromEndTime = removingFromEndTime;
    }

    public void setRemovingFromRandomPlaceTime(long removingFromRandomPlaceTime)
    {
        this.removingFromRandomPlaceTime = removingFromRandomPlaceTime;
    }

    public void setBrowsingWithIndexesTime(long browsingWithIndexesTime)
    {
        this.browsingWithIndexesTime = browsingWithIndexesTime;
    }

    public void setBrowsingWithIteratorTime(long browsingWithIteratorTime)
    {
        this.browsingWithIteratorTime = browsingWithIteratorTime;
    }

    public String toString()
    {
        return String.format("List type: %s,\nnumber of elements: %s,\ntime of adding item to the beginning: %s,\n" +
                        "time of adding item to the end: %s,\n" + "time of adding item at random place: %s,\n" +
                        "time of removing item from the beginning: %s,\n" + "time of removing item from the end: %s,\n" +
                        "time of removing item at random place: %s,\n" + "browsing using indexes: %s,\n" + "browsing using iterator: %s\n",
                listType,
                numberOfElements,
                addingToTheBeginningTime,
                addingToTheEndTime,
                addingAtRandomPlaceTime,
                removingFromBeginningTime,
                removingFromEndTime,
                removingFromRandomPlaceTime,
                browsingWithIndexesTime,
                browsingWithIteratorTime
        );
    }
}
