package com.szpitalator.organization;

import com.szpitalator.people.HospitalEmployee;
import com.szpitalator.organization.Hospital;

import java.util.List;

public interface IHospitalCreator {
    public IHospital createHospital(int numberOfRooms);
    //public List<HospitalEmployee> addEmployee(String name, String surname, IHospital hospital);
}