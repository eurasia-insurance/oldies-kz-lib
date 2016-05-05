package com.lapsa.kz.test.messages;

import com.lapsa.kz.country.KZCityType;

public class KZCityTypeMessagesBundleTest extends EnumTypeMessagesBundleTest<KZCityType> {

    @Override
    protected KZCityType[] getAllEnumValues() {
	return KZCityType.values();
    }

    @Override
    protected String getBundleBaseName() {
	return KZCityType.BUNDLE_BASENAME;
    }
}
