package com.company.set;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetFactory implements SetFactory
{
    @Override
    public <T> Set<T> provide()
    {
        return new CopyOnWriteArraySet<T>();
    }

    @Override
    public SetType type()
    {
        return SetType.COPY_ON_WRITE_ARRAY_SET;
    }
}
