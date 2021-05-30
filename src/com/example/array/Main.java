package com.example.array;

public class Main {
    public static void main(String[] args) {

        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.addLast(100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(0);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeLast();
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);



    }
}
