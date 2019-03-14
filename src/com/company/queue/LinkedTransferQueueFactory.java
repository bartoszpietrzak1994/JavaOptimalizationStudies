package com.company.queue;

import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;

public class LinkedTransferQueueFactory implements QueueFactory
{
    @Override
    public <T> Queue<T> provide(int capacity)
    {
        return new LinkedTransferQueue<>();
    }

    @Override
    public QueueType type()
    {
        return QueueType.LINKED_TRANSFER_QUEUE;
    }
}
