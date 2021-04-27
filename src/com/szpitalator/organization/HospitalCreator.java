package com.szpitalator.organization;

import com.szpitalator.people.Doctor;
import com.szpitalator.people.HospitalEmployee;
import com.szpitalator.organization.Hospital;


import java.util.ArrayList;
import java.util.List;

public class HospitalCreator implements IHospitalCreator {
    @Override
    public IHospital createHospital(int numberOfRooms) {
        numberOfRooms = 5; // docelowo to będzie cin do tego
        List<Room> roomList = new ArrayList<>();
        for (int i=0; i<numberOfRooms; i++){
            Room room = new Room("Name", i);
            roomList.add(room);
        }

        IHospital hospital = new Hospital("Szpital Leśna Góra", 150, roomList);

        List<HospitalEmployee> employeeList = new ArrayList<>();

        for (int i=0; i<numberOfRooms; i++){
            // todo HospitalEmployee zmienić na klase abstrakcyjna i tutaj tworzyc bezposniednio pielegniarki i doktorów
            employeeList.add(new Doctor("Roman", "Fitzner", hospital));
        }

        for (int i=0; i<numberOfRooms; i++){
            roomList.get(i).setCareTaker(employeeList.get(i));
        }

        return hospital;
    }
}
