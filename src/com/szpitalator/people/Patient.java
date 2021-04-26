package com.szpitalator.people;

import com.szpitalator.organization.IHospital;
import com.szpitalator.organization.Room;

public class Patient extends Person {
    private IHospital hospital;
    String disease;

    public Patient(String name, String surname){
        super(name, surname);
    }

    public void enterHospital(IHospital hospital) {
        this.hospital = hospital;
    }

    public void visitRoom() {
        Room room = hospital.getRoomForPatient(this);
        HospitalEmployee careTaker = room.getCareTaker();
        careTaker.helpPatient(this);
    }
}