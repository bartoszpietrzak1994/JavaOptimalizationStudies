package com.company.queue;

import java.util.Queue;

public interface QueueFactory
{
    <T> Queue<T> provide(int capacity);

    QueueType type();
}
