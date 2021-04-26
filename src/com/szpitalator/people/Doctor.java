package com.szpitalator.people;

import com.szpitalator.organization.IHospital;

public class Doctor extends HospitalEmployee {
    String profession;

    public Doctor(String name, String surname, IHospital hospital){
        super(name, surname, hospital);
    }
}

