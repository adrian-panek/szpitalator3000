package com.szpitalator;


import com.szpitalator.organization.IHospital;
import com.szpitalator.organization.IHospitalCreator;
import com.szpitalator.people.Disease;
import com.szpitalator.people.IPatientListCreator;
import com.szpitalator.people.Patient;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Simulation {
    private int maxIter;
    private IHospital hospital;
    private List<Patient> patientList;
    private Patient patient;
    private List<Patient> curedPatients = new LinkedList<>();
    Scanner scan = new Scanner(System.in);

    public Simulation(IHospitalCreator hospitalCreator, IPatientListCreator personListCreator, int maxIter) {
        System.out.print("Podaj liczbę pacjentów: ");
        byte numberOfPatients = scan.nextByte();
        hospital = hospitalCreator.createHospital(numberOfPatients);
        patientList = personListCreator.createPatientList(numberOfPatients);
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
            System.out.println("\nIteracja numer: " + (maxIter - iters));

//            if (isEverybodyCured()) break; todo: zaimplementować np przez sprawdzenie czy w szpitalu w mapie nextRoomForPatient jeszcze ktoś jest
            for (Patient patient : patientList) {
                if (patient.getDisease() == Disease.ZDROWY){
                    //patientList.remove(patient);
                    curedPatients.add(patient);
                } else {
                    patient.visitRoom();
                    if (patient.getDisease() != Disease.ZDROWY) {
                        System.out.println(patient.toString() + " nie został wyleczony ");
                    } else {
                        System.out.println(patient.toString() + " został wyleczony");
                    }
                }
            }
            if (curedPatients.size() == patientList.size()) {
                System.out.println("Wszyscy pacjenci są zdrowi");
                break;
            }
        } while (--iters > 0);
        System.out.println(hospital.toString());
        }
    }