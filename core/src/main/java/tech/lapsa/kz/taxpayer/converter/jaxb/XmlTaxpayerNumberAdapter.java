package tech.lapsa.kz.taxpayer.converter.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.kz.taxpayer.TaxpayerNumber;

public class XmlTaxpayerNumberAdapter extends XmlAdapter<String, TaxpayerNumber> {

    @Override
    public TaxpayerNumber unmarshal(final String v) throws Exception {
	return MyStrings.empty(v) //
		? null //
		: TaxpayerNumber.assertValid(v);
    }

    @Override
    public String marshal(final TaxpayerNumber v) throws Exception {
	return MyObjects.isNull(v) //
		? null //
		: v.getNumber();
    }
}
