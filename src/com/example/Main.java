package com.example;

import com.example.array.Array;
import com.example.linkedlist.LinkedList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;


public class Main {
    public static void main(String[] args) {
        // Student stu = new Student();
        // stu.printName();

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(111);
        System.out.println(linkedList);

        for(int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.addFirst(111);
        System.out.println(linkedList);

        linkedList.addLast(222);
        System.out.println(linkedList);

        linkedList.add(4, 444);
        System.out.println(linkedList);
        linkedList.remove(4);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }
}

class People {
    int age;

    public People(){
        age = 10;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Teacher extends People{
    String name;

    public Teacher() {
        name = "liang";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

class Student extends Teacher {
    int id;

    public Student() {
        id = 100001;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void printName(){
        System.out.println(id);
        System.out.println(name);
        System.out.println(age);
    }
}


