package com.example.queue;


import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

import java.util.Deque;

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(){
        array = new Array<>();
    }

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    @Override
    public void enQueue(E e){
        array.addLast(e);
    }

    @Override
    public int getSize(){
        return array.getSize();
    }

    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    @Override
    public E getFront(){
        return array.getFirst();
    }

    @Override
    public E deQueue(){
        return array.removeFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("queue: front [");
        for (int i = 0; i < array.getSize(); i++){
            res.append(array.get(i));
            if(i != array.getSize() - 1){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();

    }
}
