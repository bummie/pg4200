package org.pg4200.datastructure.stack;

import org.pg4200.datastructure.delete.ArrayDeleteContainer;

public class ArrayStack<T> extends ArrayDeleteContainer<T> implements MyStack<T>{

    @Override
    public void push(T value) {
        //pushing is like adding at the end
        add(value);
    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw new RuntimeException();
        }
        return get(size()-1);
    }

    @Override
    public T pop() {
        if(isEmpty()){
            throw new RuntimeException();
        }
        T value = get(size()-1);
        delete(size()-1);
        return value;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
