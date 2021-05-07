package com.szpitalator.people;

public class Person {
    String name;
    String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return new String("Name: " + name + " Surname: " + surname);
    }
}



