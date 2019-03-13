package com.company.set;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetFactory implements SetFactory
{
    @Override
    public <T> Set<T> provide()
    {
        return new TreeSet<T>();
    }

    @Override
    public SetType type()
    {
        return SetType.TREE_SET;
    }
}
