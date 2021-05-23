package com.szpitalator.people;

import com.szpitalator.organization.IHospital;

import java.util.Random;

public abstract class HospitalEmployee extends Person {
    IHospital hospital;
    Random random = new Random();

    public HospitalEmployee(String name, String surname, IHospital hospital){
        super(name, surname);
        this.hospital = hospital;
    }

    public void helpPatient(Patient patient) {
        int rand1 = random.nextInt(Disease.values().length);
        Disease disease = Disease.values()[rand1];
        patient.assignDisease(disease);

        if (disease == Disease.ZDROWY){

        } else {

        }
    }
}