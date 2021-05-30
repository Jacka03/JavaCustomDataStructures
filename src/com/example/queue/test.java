package com.example.queue;

import com.example.stack.ArrayStack;

public class test {
    public static void main(String[] args) {
        // ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        LoopQueue<Integer> arrayQueue = new LoopQueue<>();

        for (int i = 0; i < 10; i++){
            arrayQueue.enQueue(i);
            System.out.println(arrayQueue);

            if(i % 3 == 2){
                arrayQueue.deQueue();
                System.out.println(arrayQueue);
            }

        }
    }
}
