package com.szpitalator.people;

import com.szpitalator.organization.IHospital;
import com.szpitalator.people.Disease;

import java.util.Random;

public abstract class HospitalEmployee extends Person {
    IHospital hospital;
    Random random = new Random();

    public HospitalEmployee(String name, String surname, IHospital hospital){
        super(name, surname);
        this.hospital = hospital;
    }

    public void helpPatient(Patient patient) {
        // todo: przypisac chorobe do pacienta
        int rand = random.nextInt(Disease.values().length);
        Disease disease = Disease.values()[rand];
        patient.assignDisease(disease);
    }
}