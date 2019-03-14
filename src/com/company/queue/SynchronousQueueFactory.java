package com.company.queue;

import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueFactory implements QueueFactory
{
    @Override
    public <T> Queue<T> provide(int capacity)
    {
        return new SynchronousQueue<>();
    }

    @Override
    public QueueType type()
    {
        return QueueType.SYNCHRONOUS_QUEUE;
    }
}
