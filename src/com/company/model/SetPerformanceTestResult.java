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

    public void setAddingTime(long addingTime)
    {
        this.addingTime = addingTime;
    }

    public void setRemovingTime(long removingTime)
    {
        this.removingTime = removingTime;
    }

    public void setBrowsingTime(long browsingTime)
    {
        this.browsingTime = browsingTime;
    }

    public void setCheckingIfElementExistsTime(long checkingIfElementExistsTime)
    {
        this.checkingIfElementExistsTime = checkingIfElementExistsTime;
    }

    public String toString()
    {
        return String.format("Set type: %s,\nnumber of elements: %s,\ntime of adding items: %s,\ntime of browsing: %s,\n" +
                "time of checking if item exists: %s,\ntime of removing items: %s\n",
                setType,
                numberOfElements,
                addingTime,
                browsingTime,
                checkingIfElementExistsTime,
                removingTime
        );
    }
}
