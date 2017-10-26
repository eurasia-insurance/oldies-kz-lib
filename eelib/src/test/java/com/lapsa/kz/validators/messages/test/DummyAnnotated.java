package com.lapsa.kz.validators.messages.test;

import com.lapsa.kz.country.validators.ValidKZArea;
import com.lapsa.kz.country.validators.ValidKZCity;

import tech.lapsa.kz.taxpayer.validators.ValidTaxpayerNumber;
import tech.lapsa.kz.vehicle.validators.ValidVehicleRegNumber;

public interface DummyAnnotated {
    @ValidKZArea
    @ValidKZCity
    @ValidTaxpayerNumber
    @ValidVehicleRegNumber
    void dummy();
}
