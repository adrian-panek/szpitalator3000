package com.szpitalator.organization;

import com.szpitalator.people.HospitalEmployee;
import com.szpitalator.people.Patient;

public class Room {
    String name;
    int roomNumber;
    //HospitalEmployee careTaker;
    //Patient operatedPatient;

    public Room(String name, int roomNumber) {
        this.name = name;
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
