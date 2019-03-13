package com.company.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetFactory implements SetFactory
{
    @Override
    public <T> Set<T> provide()
    {
        return new HashSet<T>();
    }

    @Override
    public SetType type()
    {
        return SetType.HASH_SET;
    }
}
