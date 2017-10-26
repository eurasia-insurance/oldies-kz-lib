package tech.lapsa.kz.vehicle.converter.rs;

import javax.ws.rs.ext.ParamConverter;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.kz.vehicle.VehicleRegNumber;

public class VehicleRegNumberParamConverter implements ParamConverter<VehicleRegNumber> {

    @Override
    public VehicleRegNumber fromString(String v) {
	return VehicleRegNumber.of(v);
    }

    @Override
    public String toString(VehicleRegNumber value) {
	return MyObjects.requireNonNull(value, "value").getNumber();
    }

}
