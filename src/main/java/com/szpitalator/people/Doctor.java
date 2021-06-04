package com.szpitalator.people;

import com.szpitalator.organization.IHospital;

import java.util.Random;

public class Doctor extends HospitalEmployee {
    String profession;
    Random rand = new Random();

    public Doctor(String name, String surname, IHospital hospital){
        super(name, surname, hospital);
    }

}