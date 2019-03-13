package com.company.list;

import java.util.List;

public interface ListFactory
{
    <T> List<T> provide();

    ListType type();
}
