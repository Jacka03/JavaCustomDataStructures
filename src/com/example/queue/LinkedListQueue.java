package com.example.queue;

public class LinkedListQueue<E> implements Queue<E> {
    private class Node {
        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }

    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enQueue(E e) {
        if(tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E deQueue() {
        if(head == null) {
            throw new IllegalArgumentException("deQueue failed, queue is empty");
        }
        Node cur = head;
        head = head.next;
        size--;

        cur.next = null;
        if(head == null) {
            tail = null;
        }
        return cur.e;
    }

    @Override
    public E getFront() {
        if(head == null) {
            throw new IllegalArgumentException("get failed, queue is empty");
        }

        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue front");

        Node cur = head;
        while (cur != null) {
            res.append(cur.e + "->");
            cur = cur.next;
        }
        res.append("null tail");
        return res.toString();
    }


}
