package tech.lapsa.kz.vehicle.converter.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.kz.vehicle.VehicleRegNumber;

public class XmlVehicleRegNumberAdapter extends XmlAdapter<String, VehicleRegNumber> {

    @Override
    public VehicleRegNumber unmarshal(String v) throws Exception {
	return MyStrings.empty(v) //
		? null //
		: VehicleRegNumber.of(v);
    }

    @Override
    public String marshal(VehicleRegNumber v) throws Exception {
	return MyObjects.isNull(v) //
		? null //
		: v.getNumber();
    }

}
