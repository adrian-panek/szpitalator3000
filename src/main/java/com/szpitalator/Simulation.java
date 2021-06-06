package com.szpitalator;


import com.szpitalator.organization.IHospital;
import com.szpitalator.organization.IHospitalCreator;
import com.szpitalator.people.Disease;
import com.szpitalator.people.IPatientListCreator;
import com.szpitalator.people.Patient;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Simulation {
    private int maxIter;
    private IHospital hospital;
    private List<Patient> patientList;
    private Patient patient;
    private List<Patient> curedPatients = new LinkedList<>();
    Scanner scan = new Scanner(System.in);
    byte numberOfPatients;

    public Simulation(IHospitalCreator hospitalCreator, IPatientListCreator personListCreator, int maxIter) {
        System.out.print("Podaj liczbę pacjentów: ");
        numberOfPatients = scan.nextByte();
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
        String logs = "";
        int iters = maxIter;
        do {
            System.out.println("\nIteracja numer: " + (maxIter - iters));
            List<Patient> patientListCopy = new LinkedList<>(patientList);
            for (Patient patient : patientListCopy) {
                patient.visitRoom();
                if (patient.getDisease() == Disease.ZDROWY){
                    patientList.remove(patient);
                    curedPatients.add(patient);
                    System.out.println(patient.toString() + " został wyleczony");
                    logs += (patient.toString() + " został wyleczony\n");
                } else {
                    System.out.println(patient.toString() + " NIE został wyleczony ");
                    logs += (patient.toString() + " NIE został wyleczony\n");
                }
            }
        } while (--iters > 0);
        if (curedPatients.size() == numberOfPatients) {
            System.out.println("\nWszyscy pacjenci są zdrowi!\n");
            logs += ("\nWszyscy pacjenci są zdrowi!\n");
        } else {
            System.out.println("Niestety nie wszystkich pacjentów udało się wyleczyć. Koniec symulacji.");
            logs += "Niestety nie wszystkich pacjentów udało się wyleczyć. Koniec symulacji.\n";
        }
        try {
            FileWriter writeToFile = new FileWriter("przebieg_symulacji.txt");
            writeToFile.write(logs);
            writeToFile.close();
            System.out.println("Koniec programu, przebieg symulacji zapisany pomyślnie do pliku.");
        } catch (IOException error){
            error.printStackTrace();
            System.out.println("Wystąpił błąd podczas zapisu do pliku");
        }
    }
}