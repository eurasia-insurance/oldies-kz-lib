package com.lapsa.kz.validators.messages.test;

import com.lapsa.kz.country.validators.ValidKZArea;
import com.lapsa.kz.country.validators.ValidKZCity;
import com.lapsa.kz.idnumber.validators.ValidIdNumber;

public interface DummyAnnotated {
    @ValidKZArea
    @ValidKZCity
    @ValidIdNumber
    void dummy();
}
