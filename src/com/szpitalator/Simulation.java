package com.szpitalator;


import com.szpitalator.organization.IHospital;
import com.szpitalator.organization.IHospitalCreator;
import com.szpitalator.people.IPatientListCreator;
import com.szpitalator.people.Patient;

import java.util.List;
import java.util.Scanner;

public class Simulation {
    private int maxIter;
    private IHospital hospital;
    private List<Patient> patientList;
    Scanner scan = new Scanner(System.in);

    public Simulation(IHospitalCreator hospitalCreator, IPatientListCreator personListCreator, int maxIter) {
        System.out.println("Podaj ilość pacjentów: ");
        byte numberOfRooms = scan.nextByte();
        hospital = hospitalCreator.createHospital(numberOfRooms);
        patientList = personListCreator.createPatientList(numberOfRooms);
        this.maxIter = maxIter;

        System.out.println(hospital.toString());

        for (Patient patient : patientList) {
            patient.enterHospital(hospital);
            hospital.servePatientAtReceptionDesk(patient);
        }
    }

    public void run() {
        // todo: wyswietlic wszystkich pacientow za pomocna toString z Patient, w celu sprwadzenia poprawnego zachownia na recepcji
        int iters = maxIter;

        do {
//            if (isEverybodyCured()) break; todo: zaimplementować np przez sprawdzenie czy w szpitalu w mapie nextRoomForPatient jeszcze ktoś jest
            for (Patient patient : patientList) {
                patient.visitRoom();
            }


        } while (--iters > 0);
        System.out.println("Iteration: " + (maxIter - iters));
        System.out.println(hospital.toString());
    }
}