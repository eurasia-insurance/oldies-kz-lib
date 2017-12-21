package com.lapsa.kz.faces.vehicle;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.kz.vehicle.VehicleRegNumber;

@FacesConverter(forClass = VehicleRegNumber.class)
public class VehicleRegNumberConverter implements Converter {

    @Override
    public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {
	return MyOptionals.of(value) //
		.map(VehicleRegNumber::assertValid) //
		.orElse(null);
    }

    @Override
    public String getAsString(final FacesContext context, final UIComponent component, final Object value) {
	return MyOptionals.of(value) //
		.map(MyObjects.cast(VehicleRegNumber.class)) //
		.map(VehicleRegNumber::getNumber) //
		.orElse("");
    }
}
