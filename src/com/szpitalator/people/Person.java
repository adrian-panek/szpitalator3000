package com.szpitalator.people;

import java.util.Random;

public class Person {
    String name;
    String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    Random random = new Random();
    String[] names = {"Antoni", "Jan", "Jakub", "Aleksander", "Szymon", "Filip", "Mikołaj", "Stanisław"};
    String[] surNames = {"Nowak", "Kowalski", "Wiśniewski", "Wójcik", "Kowalczyk", "Zieliński", "Woźniak", "Szymański"};

    public String generateName(){
        String name = names[random.nextInt(names.length)];
        return name;
    }

    public String generateSurame(){
        String name = surNames[random.nextInt(surNames.length)];
        return name;
    }

    @Override
    public String toString() {
        return new String("Name: " + name + " Surname: " + surname);
    }
}



