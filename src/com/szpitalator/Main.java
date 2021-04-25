package com.szpitalator;

import com.szpitalator.organization.HospitalCreator;
import com.szpitalator.organization.IHospitalCreator;

public class Main {

    public static void main(String[] args) {

        IHospitalCreator hospitalCreator = new HospitalCreator();
        Simulation simulation = new Simulation(hospitalCreator);

        simulation.run();
    }
}
