package com.szpitalator.organization;

import com.szpitalator.people.Doctor;
import com.szpitalator.people.HospitalEmployee;
import com.szpitalator.organization.Hospital;


import java.util.ArrayList;
import java.util.List;

public class HospitalCreator implements IHospitalCreator {
    @Override
    public IHospital createHospital(int numberOfPatients) {
        List<Room> roomList = new ArrayList<>();
        for (int i=1; i<=numberOfPatients; i++){
            Room room = new Room("Name_" + i, i);
            roomList.add(room);
        }

        IHospital hospital = new Hospital("Szpital Leśna Góra", 150, roomList);

        List<HospitalEmployee> employeeList = new ArrayList<>();

        for (int i=0; i<numberOfPatients; i++){
            employeeList.add(new Doctor("Anna", "Kowalska", hospital));
        }

        for (int i=0; i<numberOfPatients; i++){
            roomList.get(i).setCareTaker(employeeList.get(i));
        }

        return hospital;
    }
}