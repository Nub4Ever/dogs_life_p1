package com.db.grad.javaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "dogs")
public class Dog
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dog_id;

    private String name;
    private int age;

    @Column(name = "dog_id")
    public long getId() {
        return dog_id;
    }

    public void setId(long dog_id) {
        this.dog_id = dog_id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "dog_id=" + dog_id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
