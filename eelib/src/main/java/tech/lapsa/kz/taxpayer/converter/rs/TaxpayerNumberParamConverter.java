package tech.lapsa.kz.taxpayer.converter.rs;

import javax.ws.rs.ext.ParamConverter;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.kz.taxpayer.TaxpayerNumber;

public class TaxpayerNumberParamConverter implements ParamConverter<TaxpayerNumber> {

    @Override
    public TaxpayerNumber fromString(String value) {
	return TaxpayerNumber.of(value);
    }

    @Override
    public String toString(TaxpayerNumber value) {
	return MyObjects.requireNonNull(value, "value").getNumber();
    }

}
