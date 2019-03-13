package com.company.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetFactory implements SetFactory
{
    @Override
    public <T> Set<T> provide()
    {
        return new LinkedHashSet<T>();
    }

    @Override
    public SetType type()
    {
        return SetType.LINKED_HASH_SET;
    }
}
