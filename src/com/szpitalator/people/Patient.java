package com.szpitalator.people;

import com.szpitalator.organization.IHospital;
import com.szpitalator.organization.Room;

public class Patient extends Person {
    private IHospital hospital;
    private Disease disease;
    private Room nextRoomToVisit;
    private DiseaseHandler handler;

    public Patient(String name, String surname) {
        super(name, surname);
    }

    public void enterHospital(IHospital hospital) {
        this.hospital = hospital;
    }

    public void visitRoom() {
        hospital.assignRoomToPatient(this, nextRoomToVisit);
        HospitalEmployee careTaker = nextRoomToVisit.getCareTaker();
        careTaker.helpPatient(this);
    }

    public void setNextRoom(Room room) {
        nextRoomToVisit = room;
    }

    public void assignDisease(Disease disease) {
        this.disease = disease;
    }

    public void assignTreatement(DiseaseHandler handler) {
        this.handler = handler;
    }

    public DiseaseHandler getHandler() { return handler; }

    @Override
    public String toString() {
        String ret = super.toString();
        ret += " chorego na: " + disease + " numer następnego pokoju: " + nextRoomToVisit.getRoomNumber() + " podjęta kuracja: " + handler;
        return ret;
    }
}