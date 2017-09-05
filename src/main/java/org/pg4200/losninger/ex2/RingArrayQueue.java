package org.pg4200.losninger.ex2;

import org.pg4200.datastructure.queue.MyQueue;

public class RingArrayQueue<T> implements MyQueue<T>{

    protected Object[] data;

    private int head = -1;
    private int tail = -1;

    /*
        Note: here we do not need to have a variable for "size" anymore,
        as we can infer it from "head" and "tail"
     */

    public RingArrayQueue(){
        this(10);
    }

    public RingArrayQueue(int capacity){
        data = new Object[capacity];
    }

    @Override
    public void enqueue(T value) {

        if(isEmpty()){
            head = 0;
            tail = 0;
        }else if(tail < data.length - 1)
        {
            if(tail + 1 == head)
            {
                Object[] tmp = new Object[data.length * 2];

                int size = data.length - 1 - head;
                for(int i = 0; i < size; i++){
                    tmp[i] = data[i + head];
                }

                for(int i = 0; i < tail; i++){
                    tmp[i + size] = data[i];
                }
                head = 0;
                tail = data.length;
                data = tmp;
            }
            else
                tail++;
        }else if(tail >= data.length - 1)
        {
            if(head > 0)
            {
                tail = 0;
            }
            else
            {
                Object[] tmp = new Object[data.length * 2];

                int  size = size();
                for(int i = 0; i < size; i++){
                    tmp[i] = data[i + head];
                }
                head = 0;
                tail = size;
                data = tmp;
            }
        }

        data[tail] = value;
    }

    @Override
    public T dequeue() {

        if(isEmpty()){
            throw new RuntimeException();
        }

        T value = (T) data[head];

        if(size() == 1){
            //now it ll be empty
            head = -1;
            tail = -1;
        } else {
            head++;
            if(head >= data.length){
                head = 0;
            }
        }

        return value;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw new RuntimeException();
        }

        return (T) data[head];
    }

    @Override
    public int size() {

        if(head < 0){
            return 0;
        }
        int size;
        if(tail >= head)
            size = (tail - head ) + 1;
        else
            size = ((data.length) - head) + tail + 1;
        return size;
    }
}
