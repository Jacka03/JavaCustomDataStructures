package com.example.stack;

public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;  // 虚拟头结点
    private int size;

    public LinkedList(){
        dummyHead = new Node(null, null);
        size = 0;
    }

    // 获取链表长度
    public int getSize(){
        return size;
    }

    // 链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 在index位置添加一个元素
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed, illegal index");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        // Node node = new Node(e);
        // node.next = prev.next;
        // prev.next = node;

        prev.next = new Node(e, prev.next);

        size++;
    }

    // 链表头添加新元素
    public void addFirst(E e) {
        add(0, e);
    }

    // 在链表末尾添加元素
    public void addLast(E e) {
        add(size, e);
    }

    // 获取链表中的元素
    public E get(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("get false, illegal index");
        }

        Node cur = dummyHead.next;

        for(int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size-1);
    }

    public void set(int index, E e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("set failed, index illegal");
        }

        Node cur = dummyHead.next;

        for(int i = 0; i < index; i++) {
            cur = cur.next;
        }

        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while(cur != null) {
            if(cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed, index illegel");
        }

        Node prev = dummyHead;
        for(int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;

        size--;
        return delNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size-1);
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur.e + "->");
            cur = cur.next;
        }
        res.append("null");
        return res.toString();
    }

}
