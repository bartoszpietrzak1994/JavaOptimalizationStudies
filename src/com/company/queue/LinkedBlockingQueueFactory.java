package com.company.queue;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueFactory implements QueueFactory
{
    @Override
    public <T> Queue<T> provide(int capacity)
    {
        return new LinkedBlockingQueue<T>(capacity);
    }

    @Override
    public QueueType type()
    {
        return QueueType.LINKED_BLOCKING_QUEUE;
    }
}
