package com.szpitalator.people;

import com.szpitalator.organization.IHospital;

public abstract class HospitalEmployee extends Person {
    IHospital hospital;

    public HospitalEmployee(String name, String surname, IHospital hospital){
        super(name, surname);
        this.hospital = hospital;
    }

    public void helpPatient(Patient patient) {

    }
}