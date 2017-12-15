package tech.lapsa.kz.vehicle.converter.rs;

import java.util.Map.Entry;

import javax.ws.rs.ext.ParamConverter;

import tech.lapsa.java.commons.function.MyMaps;
import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.javax.rs.params.MyParamConverterProvider;
import tech.lapsa.kz.vehicle.VehicleRegNumber;

public class VehicleRegNumberParamConverter
	implements ParamConverter<VehicleRegNumber>, MyParamConverterProvider<VehicleRegNumber> {

    @Override
    public VehicleRegNumber fromString(final String v) {
	return VehicleRegNumber.assertValid(v);
    }

    @Override
    public String toString(final VehicleRegNumber value) {
	return MyObjects.requireNonNull(value, "value").getNumber();
    }

    private static Entry<Class<VehicleRegNumber>, ParamConverter<VehicleRegNumber>> ENTRY = MyMaps
	    .entry(VehicleRegNumber.class, new VehicleRegNumberParamConverter());

    @Override
    public Entry<Class<VehicleRegNumber>, ParamConverter<VehicleRegNumber>> entry() {
	return ENTRY;
    }
}
