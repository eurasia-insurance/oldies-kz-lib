package tech.lapsa.kz.vehicle.converter.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import tech.lapsa.kz.vehicle.VehicleRegNumber;

@Converter(autoApply = true)
public class VehicleRegNumberAttributeConverter implements AttributeConverter<VehicleRegNumber, String> {

    @Override
    public String convertToDatabaseColumn(final VehicleRegNumber attribute) {
	return attribute == null ? null : attribute.getNumber();
    }

    @Override
    public VehicleRegNumber convertToEntityAttribute(final String dbData) {
	return dbData == null ? null : VehicleRegNumber.assertValid(VehicleRegNumber.normalizeNumber(dbData));
    }

}
