package com.szpitalator.people;

import com.szpitalator.organization.IHospital;
import com.szpitalator.organization.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;


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

        Set<Room> keySet = this.hospital.getRooms().keySet();
        List<Room> keyList = new ArrayList<>(keySet);
        int randomIndex = random.nextInt(this.hospital.getRooms().size());
        Room nextRandomRoom = keyList.get(randomIndex);
        patient.setNextRoom(nextRandomRoom);

    }
}