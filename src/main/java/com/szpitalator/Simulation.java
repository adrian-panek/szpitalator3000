package com.szpitalator;


import com.szpitalator.organization.IHospital;
import com.szpitalator.organization.IHospitalCreator;
import com.szpitalator.people.Disease;
import com.szpitalator.people.IPatientListCreator;
import com.szpitalator.people.Patient;

import java.io.FileWriter;
import java.io.IOException;
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
<<<<<<< HEAD:src/main/java/com/szpitalator/Simulation.java
        // todo: wyswietlic wszystkich pacientow za pomocna toString z Patient, w celu sprwadzenia poprawnego zachownia na recepcji
        String logs = "";
        int iters = maxIter;
        do {
            System.out.println("\nIteracja numer: " + (maxIter - iters));

//            if (isEverybodyCured()) break; todo: zaimplementować np przez sprawdzenie czy w szpitalu w mapie nextRoomForPatient jeszcze ktoś jest
=======
        int iters = maxIter;
        do {
            System.out.println("\nIteracja numer: " + (maxIter - iters));
>>>>>>> 98bb55635564cf41abc4d401268cd506425697e3:src/com/szpitalator/Simulation.java
            List<Patient> patientListCopy = new LinkedList<>(patientList);
            for (Patient patient : patientListCopy) {
                patient.visitRoom();
                if (patient.getDisease() == Disease.ZDROWY){
                    patientList.remove(patient);
                    curedPatients.add(patient);
<<<<<<< HEAD:src/main/java/com/szpitalator/Simulation.java
                    logs += (patient.toString() + " został wyleczony" + "\n");
                    System.out.println(patient.toString() + " został wyleczony");
                } else {
                    logs += (patient.toString() + " NIE został wyleczony " + "\n");
=======
                    System.out.println(patient.toString() + " został wyleczony");
                } else {
>>>>>>> 98bb55635564cf41abc4d401268cd506425697e3:src/com/szpitalator/Simulation.java
                    System.out.println(patient.toString() + " NIE został wyleczony ");
                }
            }
            if (curedPatients.size() == numberOfPatients) {
                System.out.println("\nWszyscy pacjenci są zdrowi!\n");
                break;
            }
            try {
                FileWriter writer = new FileWriter("przebieg_symulacji.txt");
                writer.write(logs);
                writer.close();
            } catch (IOException error){
                System.out.println("Wystąpił błąd podczas zapisu do pliku");
                error.printStackTrace();
            }
            System.out.println("Koniec symulacji, przebieg mozna odczytać w pliku");
        } while (--iters > 0);
<<<<<<< HEAD:src/main/java/com/szpitalator/Simulation.java
=======
        if (curedPatients.size() != numberOfPatients){
            System.out.println("Niestety nie udało się wyleczyć wszystkich pacjentów. Koniec symulacji");
        }
>>>>>>> 98bb55635564cf41abc4d401268cd506425697e3:src/com/szpitalator/Simulation.java
    }
}