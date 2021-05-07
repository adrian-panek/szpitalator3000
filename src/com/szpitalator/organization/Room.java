package com.szpitalator.organization;

import com.szpitalator.people.HospitalEmployee;

public class Room {
    String name;
    int roomNumber;
    HospitalEmployee careTaker;
    //Patient operatedPatient;

    public HospitalEmployee getCareTaker() {
        return careTaker;
    }

    public void setCareTaker(HospitalEmployee careTaker) {
        this.careTaker = careTaker;
    }

    public Room(String name, int roomNumber) {
        this.name = name;
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return new String("Room: " + name + " no: " + roomNumber);
    }

    public int getRoomNumber() {
        return roomNumber;
    }
}