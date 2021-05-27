package com.example;

import java.util.Arrays;

public class Array<E> {
    private E[] data;
    private int size;

    /**
     * 无数构造函数
     */
    public Array(){
        this(10);
    }

    /**
     * 有参数构造函数
     * @param capacity
     */
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * 获取数组中元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在数组末尾添加元素
     * @param e
     */
    public void addLast(E e){
        add(size, e);
    }

    /**
     * 在数组开头添加元素
     * @param e
     */
    public void addFirst(E e){
        add(0, e);
    }

    /**
     * 在数组任意位置添加元素
     * @param index
     * @param e
     */
    public void add(int index, E e){

        if(index < 0 || index > size){
            throw new IllegalArgumentException("add error, array index illegal");
        }

        if(size == data.length){
            resize(2*data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取index的元素
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("add error, array index illegal");
        }
        return data[index];
    }

    /**
     * 设置index元素的值
     * @return
     */
    public void set(int index, E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("add error, array index illegal");
        }
        data[index] = e;
    }

    /**
     * 数组中是否包含元素e
     * @return
     */
    public boolean contain(E e){
        for(int i = 0; i < size; i++){
            if(data[i] == e){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找元素在数组中的位置
     * @return
     */
    public int find(E e){
        for(int i = 0; i < size; i++){
            if(data[i] == e){
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除并且返回
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("del error, array index illegal");
        }

        E res = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i+1];
        }
        size--;
        data[size] = null;
        return res;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public void removeElement(E e){
        // 数组中可能存在多个，
        int index = find(e);
        if(index != -1){
            remove(index);
        }

    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        sb.append('[');
        for(int i = 0; i < size; i++){
            sb.append(data[i]);
            if(i != size - 1){
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;

    }
}
