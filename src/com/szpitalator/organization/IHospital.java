package com.szpitalator.organization;

import com.szpitalator.people.HospitalEmployee;
import com.szpitalator.people.Patient;

public interface IHospital {
    public int getSize();
    public void servePatientAtReceptionDesk(Patient patient);
    public Room getRoomForPatient(Patient patient);
    public void addEmployee(HospitalEmployee employee);
}