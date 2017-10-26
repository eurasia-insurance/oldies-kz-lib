package tech.lapsa.kz.taxpayer.converter.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.kz.taxpayer.TaxpayerNumber;

public class XmlTaxpayerNumberAdapter extends XmlAdapter<String, TaxpayerNumber> {

    @Override
    public TaxpayerNumber unmarshal(String v) throws Exception {
	return TaxpayerNumber.of(v);
    }

    @Override
    public String marshal(TaxpayerNumber v) throws Exception {
	return MyObjects.requireNonNull(v, "taxpayerNumber").getNumber();
    }

}
