package com.lapsa.kz.test.messages;

import com.lapsa.kz.country.KZCity;

public class KZCityMessagesBundleTest extends EnumTypeMessagesBundleTest<KZCity>{

    @Override
    protected KZCity[] getAllEnumValues() {
	return KZCity.values();
    }

    @Override
    protected String getBundleBaseName() {
	return KZCity.BUNDLE_BASENAME;
    }
}
