package com.lapsa.kz.test.messages;

import com.lapsa.kz.economic.KZEconomicSector;

public class KZEconomicSectorMessagesBundleTest extends EnumTypeMessagesBundleTest<KZEconomicSector> {

    @Override
    protected KZEconomicSector[] getAllEnumValues() {
	return KZEconomicSector.values();
    }

    @Override
    protected String getBundleBaseName() {
	return KZEconomicSector.BUNDLE_BASENAME;
    }
}
