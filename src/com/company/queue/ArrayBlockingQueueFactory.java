package com.company.queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueFactory implements QueueFactory
{
    @Override
    public <T> Queue<T> provide(int capacity)
    {
        return new ArrayBlockingQueue<T>(capacity);
    }

    @Override
    public QueueType type()
    {
        return QueueType.ARRAY_BLOCKING_QUEUE;
    }
}
