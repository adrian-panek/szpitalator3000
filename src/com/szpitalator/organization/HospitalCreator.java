package com.szpitalator.organization;

import com.szpitalator.organization.IHospitalCreator;

public class HospitalCreator implements IHospitalCreator {
    public IHospital createHospital() {
        IHospital hospital = new Hospital();
        return hospital;
    }
};

