package com.szpitalator.organization;

import com.szpitalator.people.HospitalEmployee;

import java.util.List;

public class Hospital implements IHospital{
    String name;
    long surface;
    List<HospitalEmployee> employees;
    List<Room> roomList;

    public Hospital(String name, long surface, List<Room> roomList) {
        this.name = name;
        this.surface = surface;
        this.roomList = roomList;
    }

    public int getSize(){return roomList.size();}
}