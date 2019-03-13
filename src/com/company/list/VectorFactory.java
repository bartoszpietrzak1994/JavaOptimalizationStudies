package com.company.list;

import java.util.List;
import java.util.Vector;

public class VectorFactory implements ListFactory
{
    @Override
    public <T> List<T> provide()
    {
        return new Vector<T>();
    }

    @Override
    public ListType type()
    {
        return ListType.VECTOR;
    }
}
