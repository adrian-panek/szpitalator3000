package com.szpitalator.organization;

import com.szpitalator.people.Doctor;
import com.szpitalator.people.HospitalEmployee;
import com.szpitalator.people.Patient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Hospital implements IHospital{
    private String name;
    private long surface;
    private List<HospitalEmployee> employeeList;
    private List<Room> roomList;
    private Map<Patient, Integer> patientsByRooms;
    private Map<Patient, Integer> nextRoomForPatient;


    public Hospital(String name, long surface, List<Room> roomList) {
        this.name = name;
        this.surface = surface;
        this.roomList = roomList;
        patientsByRooms = new HashMap<>();
        nextRoomForPatient = new HashMap<>();
        employeeList = new ArrayList<>();
    }

    @Override
    public int getSize(){return roomList.size();}

    @Override
    public void servePatientAtReceptionDesk(Patient patient) {
        Random random = new Random();
        int randomIndex = random.nextInt(roomList.size());
        nextRoomForPatient.put(patient, randomIndex);
        System.out.println(patient);

    }

    @Override
    public Room getRoomForPatient(Patient patient) {
        int roomId = nextRoomForPatient.get(patient);
//        System.out.println(roomId);

        return roomList.get(roomId);
    }

    @Override
    public String toString() {
        String ret = new  String("Hospital: " + name);
        ret += "\nRooms: \n";
        for (Room room : roomList) {
            ret += room.toString();
            ret += '\n';
        }
        return  ret;
    }
}