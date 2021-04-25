package com.szpitalator.organization;

import java.util.LinkedList;
import java.util.List;

public class HospitalCreator implements IHospitalCreator {
    @Override
    public IHospital createHospital() {
        List<Room> roomList = new LinkedList<>();
        for (int i=0; i<5; i++){
            Room room = new Room("Name", 15);
            roomList.add(room);
        }
        IHospital hospital = new Hospital("Hospital", 150, roomList);
        return hospital;
    }
}

