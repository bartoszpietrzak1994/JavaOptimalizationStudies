package com.company.set;

import java.util.Set;

public interface SetFactory
{
    <T> Set<T> provide();

    SetType type();
}
