package org.pg4200.datastructure.queue;

import org.pg4200.losninger.ex2.RingArrayQueue;

/**
 * Created by arcuri82 on 16-Aug-17.
 */
public class RingArrayQueueTest extends MyQueueTestTemplate{

    @Override
    protected <T> MyQueue<T> getNewInstance(Class<T> klass) {
        return new RingArrayQueue<>();
    }
}