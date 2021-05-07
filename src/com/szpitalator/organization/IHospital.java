package com.szpitalator.organization;

import com.szpitalator.people.HospitalEmployee;
import com.szpitalator.people.Patient;

public interface IHospital {
    public int getSize();
    public void servePatientAtReceptionDesk(Patient patient);
    public boolean assignRoomToPatient(Patient patient, Room room);
}