package com.company.list;

import java.util.LinkedList;
import java.util.List;

public class LinkedListFactory implements ListFactory
{
    @Override
    public <T> List<T> provide()
    {
        return new LinkedList<T>();
    }

    @Override
    public ListType type()
    {
        return ListType.LINKED_LIST;
    }
}
