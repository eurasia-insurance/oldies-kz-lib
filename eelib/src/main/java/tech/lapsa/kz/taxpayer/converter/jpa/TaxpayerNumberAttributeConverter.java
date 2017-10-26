package tech.lapsa.kz.taxpayer.converter.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import tech.lapsa.kz.taxpayer.TaxpayerNumber;

@Converter(autoApply = true)
public class TaxpayerNumberAttributeConverter implements AttributeConverter<TaxpayerNumber, String> {

    @Override
    public String convertToDatabaseColumn(TaxpayerNumber attribute) {
	return attribute == null ? null : attribute.getNumber();
    }

    @Override
    public TaxpayerNumber convertToEntityAttribute(String dbData) {
	return dbData == null ? null : TaxpayerNumber.of(dbData);
    }

}
