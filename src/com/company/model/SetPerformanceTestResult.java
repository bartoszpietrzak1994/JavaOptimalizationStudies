package com.company.model;

import com.company.set.SetType;

public class SetPerformanceTestResult implements PerformanceTestResult
{
    private SetType setType;
    private int numberOfElements;
    private long addingTime;
    private long removingTime;
    private long browsingTime;
    private long checkingIfElementExistsTime;

    public String getType()
    {
        return setType.toString();
    }

    public void setType(SetType setType)
    {
        this.setType = setType;
    }

    public int getNumberOfElements()
    {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements)
    {
        this.numberOfElements = numberOfElements;
    }

    public long getAddingTime()
    {
        return addingTime;
    }

    public void setAddingTime(long addingTime)
    {
        this.addingTime = addingTime;
    }

    public long getRemovingTime()
    {
        return removingTime;
    }

    public void setRemovingTime(long removingTime)
    {
        this.removingTime = removingTime;
    }

    public long getBrowsingTime()
    {
        return browsingTime;
    }

    public void setBrowsingTime(long browsingTime)
    {
        this.browsingTime = browsingTime;
    }

    public long getCheckingIfElementExistsTime()
    {
        return checkingIfElementExistsTime;
    }

    public void setCheckingIfElementExistsTime(long checkingIfElementExistsTime)
    {
        this.checkingIfElementExistsTime = checkingIfElementExistsTime;
    }

    public String toString()
    {
        return String.format("Set getType: %s, number of elements: %s, time of adding items: %s, time of browsing: %s, " +
                "time of checking if item exists: %s, time of removing items: %s",
                setType,
                numberOfElements,
                addingTime,
                browsingTime,
                checkingIfElementExistsTime,
                removingTime
        );
    }
}
