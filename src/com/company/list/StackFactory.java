package com.company.list;

import java.util.List;
import java.util.Stack;

public class StackFactory implements ListFactory
{
    @Override
    public <T> List<T> provide()
    {
        return new Stack<T>();
    }

    @Override
    public ListType type()
    {
        return ListType.STACK;
    }
}
