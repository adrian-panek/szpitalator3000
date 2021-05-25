package com.szpitalator.people;

import java.util.Random;

public class Person {
    String name;
    String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return new String("imię: " + name + " nazwisko: " + surname);
    }
}



