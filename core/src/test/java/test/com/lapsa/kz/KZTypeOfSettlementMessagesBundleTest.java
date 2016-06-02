package test.com.lapsa.kz;

import com.lapsa.kz.country.KZTypeOfSettlement;

public class KZTypeOfSettlementMessagesBundleTest extends EnumTypeMessagesBundleTest<KZTypeOfSettlement> {

    @Override
    protected KZTypeOfSettlement[] getAllEnumValues() {
	return KZTypeOfSettlement.values();
    }

    @Override
    protected String getBundleBaseName() {
	return KZTypeOfSettlement.BUNDLE_BASENAME;
    }
}
