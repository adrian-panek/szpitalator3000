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

        int rand2 = random.nextInt(DiseaseHandler.values().length);
        DiseaseHandler handler = DiseaseHandler.values()[rand2];
        patient.assignTreatement(handler);
    }
}