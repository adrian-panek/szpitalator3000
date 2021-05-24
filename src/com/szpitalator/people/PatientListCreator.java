package com.szpitalator.people;

import com.szpitalator.people.Person;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PatientListCreator implements IPatientListCreator {
    Random rand = new Random();

    final String[] names = {"Antoni", "Jan", "Jakub", "Aleksander", "Franciszek", "Szymon", "Filip", "Mikołaj", "Staniwsław",
            "Wojciech", "Adam"};

    final String[] surnames = {"Nowak", "Kowalski", "Wiśniewski", "Wójcik", "Kowalczyk", "Kamiński", "Zieliński", "Szymański", "Lewandowski",
            "Woźniak", "Wojciechowski"};
    @Override
    public List<Patient> createPatientList(int numberOfPatients) {
        List <Patient> patientList = new LinkedList<>();
        for (int i=0; i<numberOfPatients; i++){
            Patient patient = new Patient(generateName(names), generateSurame(surnames));
            patientList.add(patient);
        }
        return patientList;
    }

    private String generateName(String[] names){
        int randomIndex = rand.nextInt(names.length);
        return names[randomIndex];
    }

    private String generateSurame(String[] surnames){
        int randomIndex = rand.nextInt(surnames.length);
        return surnames[randomIndex];
    }
}