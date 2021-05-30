package com.example.queue;

public interface Queue<E> {

    void enQueue(E e);
    E deQueue();
    E getFront();
    int getSize();
    boolean isEmpty();

}
