package tech.lapsa.kz.taxpayer.converter.rs;

import java.util.Map.Entry;

import javax.ws.rs.ext.ParamConverter;

import tech.lapsa.java.commons.function.MyMaps;
import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.javax.rs.params.MyParamConverterProvider;
import tech.lapsa.kz.taxpayer.TaxpayerNumber;

public class TaxpayerNumberParamConverter
	implements ParamConverter<TaxpayerNumber>, MyParamConverterProvider<TaxpayerNumber> {

    @Override
    public TaxpayerNumber fromString(String value) {
	return TaxpayerNumber.assertValid(value);
    }

    @Override
    public String toString(TaxpayerNumber value) {
	return MyObjects.requireNonNull(value, "value").getNumber();
    }

    private static Entry<Class<TaxpayerNumber>, ParamConverter<TaxpayerNumber>> ENTRY = MyMaps
	    .entry(TaxpayerNumber.class, new TaxpayerNumberParamConverter());

    @Override
    public Entry<Class<TaxpayerNumber>, ParamConverter<TaxpayerNumber>> entry() {
	return ENTRY;
    }
}
