package com.qa.model;
public class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String sayHello() {
        return "Oh hello! You're back! Hello! Hello! "
                + "I missed you! Hello!";
    }

    @Override
    public String move() {
        return "Ruuuuuuuuuuun!";
    }

    public String toString() {
        return "Dog: " + super.toString();
    }
}