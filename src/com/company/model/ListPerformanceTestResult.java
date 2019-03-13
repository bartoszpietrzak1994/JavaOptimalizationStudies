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

    public long getAddingToTheBeginningTime()
    {
        return addingToTheBeginningTime;
    }

    public void setAddingToTheBeginningTime(long addingToTheBeginningTime)
    {
        this.addingToTheBeginningTime = addingToTheBeginningTime;
    }

    public long getAddingToTheEndTime()
    {
        return addingToTheEndTime;
    }

    public void setAddingToTheEndTime(long addingToTheEndTime)
    {
        this.addingToTheEndTime = addingToTheEndTime;
    }

    public long getAddingAtRandomPlaceTime()
    {
        return addingAtRandomPlaceTime;
    }

    public void setAddingAtRandomPlaceTime(long addingAtRandomPlaceTime)
    {
        this.addingAtRandomPlaceTime = addingAtRandomPlaceTime;
    }

    public long getRemovingFromBeginningTime()
    {
        return removingFromBeginningTime;
    }

    public void setRemovingFromBeginningTime(long removingFromBeginningTime)
    {
        this.removingFromBeginningTime = removingFromBeginningTime;
    }

    public long getRemovingFromEndTime()
    {
        return removingFromEndTime;
    }

    public void setRemovingFromEndTime(long removingFromEndTime)
    {
        this.removingFromEndTime = removingFromEndTime;
    }

    public long getRemovingFromRandomPlaceTime()
    {
        return removingFromRandomPlaceTime;
    }

    public void setRemovingFromRandomPlaceTime(long removingFromRandomPlaceTime)
    {
        this.removingFromRandomPlaceTime = removingFromRandomPlaceTime;
    }

    public long getBrowsingWithIndexesTime()
    {
        return browsingWithIndexesTime;
    }

    public void setBrowsingWithIndexesTime(long browsingWithIndexesTime)
    {
        this.browsingWithIndexesTime = browsingWithIndexesTime;
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
        return String.format("List getType: %s, number of elements: %s, time of adding item to the beginning: %s, " +
                        "time of adding item to the end: %s, " + "time of adding item at random place: %s, " +
                        "time of removing item from the beginning: %s, " + "time of removing item from the end: %s, " +
                        "time of removing item at random place: %s, " + "browsing using indexes: %s, " + "browsing using iterator: %s",
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
