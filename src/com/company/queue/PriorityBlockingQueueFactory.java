package com.company.queue;

import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueFactory implements QueueFactory
{
    @Override
    public <T> Queue<T> provide(int capacity)
    {
        return new PriorityBlockingQueue<T>(capacity);
    }

    @Override
    public QueueType type()
    {
        return QueueType.PRIORITY_BLOCKING_QUEUE;
    }
}
