package com.szpitalator.people;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PatientListCreator implements IPatientListCreator {
    String[] names = {"Antoni", "Jan", "Jakub", "Aleksander", "Szymon", "Filip", "Mikołaj", "Stanisław"};
    String[] surNames = {"Nowak", "Kowalski", "Wiśniewski", "Wójcik", "Kowalczyk", "Zieliński", "Woźniak", "Szymański"};
    Random random = new Random();
    Person person;

    public String generateName(){
        String name = names[random.nextInt(names.length)];
        return name;
    }

    public String generateSurname(){
        String name = surNames[random.nextInt(surNames.length)];
        return name;
   }

    @Override
    public List<Patient> createPatientList(int numberOfRooms) {
        List <Patient> patientList = new LinkedList<>();
        for (int i=0; i<numberOfRooms; i++){
            Patient patient = new Patient(generateName(), generateSurname());
            patientList.add(patient);
        }
        return patientList;
    }
}
