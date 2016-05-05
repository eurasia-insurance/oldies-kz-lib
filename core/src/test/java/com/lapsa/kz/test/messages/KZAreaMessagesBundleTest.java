package com.lapsa.kz.test.messages;

import com.lapsa.kz.country.KZArea;

public class KZAreaMessagesBundleTest extends EnumTypeMessagesBundleTest<KZArea>{

    @Override
    protected KZArea[] getAllEnumValues() {
	return KZArea.values();
    }

    @Override
    protected String getBundleBaseName() {
	return KZArea.BUNDLE_BASENAME;
    }
}
