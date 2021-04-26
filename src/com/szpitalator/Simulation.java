package com.szpitalator;


import com.szpitalator.organization.IHospital;
import com.szpitalator.organization.IHospitalCreator;
import com.szpitalator.people.IPatientListCreator;
import com.szpitalator.people.Patient;

import java.util.List;

public class Simulation {
    private int maxIter;
    private IHospital hospital;
    private List<Patient> patientList;

    public Simulation(IHospitalCreator hospitalCreator, IPatientListCreator personListCreator, int maxIter) {
        int numberOfRooms = 5;
        hospital = hospitalCreator.createHospital(numberOfRooms);
        patientList = personListCreator.createPatientList();
        this.maxIter = maxIter;

        System.out.println(hospital.toString());

        for (Patient patient : patientList) {
            patient.enterHospital(hospital);
            hospital.servePatientAtReceptionDesk(patient);
        }
    }

    public void run() {

        int iters = maxIter;
        do {
//            if (isEverybodyCured()) break; todo: zaimplementować np przez sprawdzenie czy w szpitalu w mapie nextRoomForPatient jeszcze ktoś jest
            for (Patient patient : patientList) {
                patient.visitRoom();
            }
        } while (--iters > 0);

    }
}