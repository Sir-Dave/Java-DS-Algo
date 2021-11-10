package com.sirdave.data_structures;

import java.util.LinkedList;

public abstract class Animal {
    protected String name;
    protected int order;

    public Animal(String name){
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isOlderThan(Animal a){
        return this.order < a.getOrder();
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

class AnimalQueue{

    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    int order = 0;

    void dequeueAny(){
        if (dogs.isEmpty()) dequeueCats();
        else  if (cats.isEmpty()) dequeueDogs();

        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if (dog != null && cat != null){
            if (dog.isOlderThan(cat))dequeueDogs();
            else dequeueCats();
        }
    }

    void enqueue(Animal a){
        a.setOrder(order);
        order++;

        if (a instanceof Dog) dogs.addLast((Dog) a);
        else if (a instanceof Cat) cats.addLast((Cat) a);
    }

    void dequeueDogs(){
        dogs.poll();
    }

    void dequeueCats(){
        cats.poll();
    }

    public static void main(String[] args) {
        AnimalQueue queue = new AnimalQueue();
        queue.enqueue(new Dog("Max"));
        queue.enqueue(new Cat("Kathie"));
        queue.enqueue(new Cat("Bill"));
        queue.enqueue(new Dog("Rex"));
        queue.enqueue(new Dog("Jackie"));
        queue.enqueue(new Cat("Dart"));

        queue.dequeueAny();
        queue.dequeueAny();

        assert queue.dogs.peek() != null;
        System.out.println(queue.dogs.peek().name);

        assert queue.cats.peek() != null;
        System.out.println(queue.cats.peek().name);
    }

}