package com.example.stack;

public class Test {
    public static void main(String[] args) {
        // ArrayStack<Integer> stack = new ArrayStack<>();
        // for (int i = 0; i < 10; i++){
        //     stack.push(i);
        //     System.out.println(stack);
        // }
        // stack.pop();
        // System.out.println(stack);
        // stack.pop();
        // System.out.println(stack);
        LinkedListStack<Integer> list = new LinkedListStack<>();
        for(int i = 0; i < 10; i++) {
            list.push(i);
            System.out.println(list);
        }
        list.pop();
        System.out.println(list);
        list.pop();
        System.out.println(list);

    }
}
