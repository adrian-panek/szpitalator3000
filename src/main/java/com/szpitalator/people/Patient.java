package com.szpitalator.people;

import com.szpitalator.organization.IHospital;
import com.szpitalator.organization.Room;

public class Patient extends Person {
    private IHospital hospital;
    private Disease disease;
    private Room nextRoomToVisit;

    public Patient(String name, String surname) {
        super(name, surname);
    }

    public void enterHospital(IHospital hospital) {
        this.hospital = hospital;
    }

    public void visitRoom() {
        if (nextRoomToVisit != null){
            hospital.assignRoomToPatient(this, nextRoomToVisit);
            HospitalEmployee careTaker = nextRoomToVisit.getCareTaker();
            careTaker.helpPatient(this);
        }
    }

    public void setNextRoom(Room room) {
        nextRoomToVisit = room;
    }

    public void assignDisease(Disease disease) {
        this.disease = disease;
    }

    @Override
    public String toString() {
        String ret = super.toString();
        ret += " chorego na: " + disease + " numer następnego pokoju: " + nextRoomToVisit.getRoomNumber();
        return ret;
    }

    public Disease getDisease() {
        return disease;
    }
}