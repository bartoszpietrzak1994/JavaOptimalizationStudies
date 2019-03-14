package com.company.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueFactory implements QueueFactory
{
    @Override
    public <T> Queue<T> provide(int capacity)
    {
        return new PriorityQueue<T>(capacity);
    }

    @Override
    public QueueType type()
    {
        return QueueType.PRIORITY_QUEUE;
    }
}
