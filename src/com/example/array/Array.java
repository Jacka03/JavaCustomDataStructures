package com.example.array;

public class Array<E> {
    private E[] data;
    private int size;

    /**
     * 无数构造函数
     * 默认数组大小为10
     */
    public Array(){
        this(10);
    }

    /**
     * 有参数构造函数
     * @param capacity 数组大小
     */
    public Array(int capacity){
        if(capacity < 0)
            throw new IllegalArgumentException("error ");

        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * 获取数组中元素个数
     * @return 数组中元素个数
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组的容量
     * @return 数组的容量
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 数组是否为空
     * @return boolean，数组是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在数组末尾添加元素
     * @param e 要添加的元素
     */
    public void addLast(E e){
        add(size, e);
    }

    /**
     * 在数组开头添加元素
     * @param e 要添加的元素
     */
    public void addFirst(E e){
        add(0, e);
    }

    /**
     * 在数组任意位置添加元素
     * @param index 添加的位置
     * @param e 要添加的元素
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
     * @param index 位置
     * @return 位于index的元素
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("add error, array index illegal");
        }
        return data[index];
    }


    /**
     * 设置index元素的值
     * @param index 位置
     * @param e 元素
     */
    public void set(int index, E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("add error, array index illegal");
        }
        data[index] = e;
    }

    /**
     * 数组中是否包含元素e
     * @param e 元素
     * @return 是否包含
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
     * @param e 元素
     * @return 位置，-1代表不
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
     * @param index 位置
     * @return 删除后的
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
        if(size == data.length/4 && data.length/2 != 0){
            resize(data.length/2);
        }
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
