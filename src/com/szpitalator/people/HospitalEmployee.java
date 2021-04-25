package com.szpitalator.people;

public class HospitalEmployee extends Person {
    int id;

    public HospitalEmployee(String name, String surname, int id){
        super(name, surname);
        this.id = id;
    }
}