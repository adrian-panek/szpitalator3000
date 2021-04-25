package com.szpitalator.people;

import java.util.LinkedList;
import java.util.List;

public class PatientListCreator implements IPatientListCreator {
    @Override
    public List<Patient> createPatientList() {
        List <Patient> patientList = new LinkedList<>();
        for (int i=0; i<5; i++){
            Patient patient = new Patient("Jan", "Kowalski");
            patientList.add(patient);
        }
        return patientList;
    }
}
