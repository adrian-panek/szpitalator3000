package com.szpitalator;

import com.szpitalator.organization.HospitalCreator;
import com.szpitalator.organization.IHospitalCreator;
import com.szpitalator.people.IPatientListCreator;
import com.szpitalator.people.PatientListCreator;

public class Main {

    public static void main(String[] args) {

        IHospitalCreator hospitalCreator = new HospitalCreator();
        IPatientListCreator patientListCreator = new PatientListCreator();

        Simulation simulation = new Simulation(hospitalCreator, patientListCreator);

        simulation.run();
    }
}
