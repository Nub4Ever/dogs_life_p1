package com.db.grad.javaapi.model;

import javax.persistence.*;

@Entity
@Table(name="dogs")
public class Dog
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dog_id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    public long getId() {
        return dog_id;
    }

    public void setId(long dog_id) {
        this.dog_id = dog_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + dog_id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
