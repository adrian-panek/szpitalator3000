package com.szpitalator.organization;

import com.szpitalator.people.HospitalEmployee;
import com.szpitalator.people.Patient;

import java.util.*;

public class Hospital implements IHospital {
    private String name;
    private long surface;
    private List<HospitalEmployee> employeeList;
    private Map<Room, Patient> rooms;
    private Random random;


    public Hospital(String name, long surface, List<Room> roomList) {
        this.name = name;
        this.surface = surface;
        rooms = new HashMap<>();

        for (Room room : roomList) {
            rooms.put(room, null);
        }

        employeeList = new ArrayList<>();
        random = new Random();
    }

    @Override
    public int getSize() {
        return rooms.size();
    }

    @Override
    public void servePatientAtReceptionDesk(Patient patient) {
        int randomIndex = random.nextInt(rooms.size());
        Set<Room> keySet = rooms.keySet();
        List<Room> keyList = new ArrayList<>(keySet);
        Room randomRoom = keyList.get(randomIndex);
        patient.setNextRoom(randomRoom);
    }

    @Override
    public boolean assignRoomToPatient(Patient patient, Room room) {
        Patient patientInRoom = rooms.get(room);
        if (patientInRoom != null) {
            return false;
        }
        rooms.put(room, patient);
        return true;
    }

    @Override
    public String toString() {
        String ret = new String("Hospital: " + name);
        ret += "\nRooms: \n";

        for (Map.Entry<Room, Patient> value : rooms.entrySet()) {
            Room room = value.getKey();
            Patient patient = value.getValue();
            ret += value.getKey().toString();
            if (patient != null) {
                ret += " zajęty przez pacjenta: " + patient.toString();
            } else {
                ret += " pusty";
            }
            ret += '\n';
        }

        return ret;
    }
}