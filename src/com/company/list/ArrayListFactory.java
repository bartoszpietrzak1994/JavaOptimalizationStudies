package com.company.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListFactory implements ListFactory
{
    @Override
    public <T> List<T> provide()
    {
        return new ArrayList<T>();
    }

    @Override
    public ListType type()
    {
        return ListType.ARRAY_LIST;
    }
}
