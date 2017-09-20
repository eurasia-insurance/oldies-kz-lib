package test.localization;

import com.lapsa.kz.country.KZTypeOfSettlement;

public class KZTypeOfSettlementMessagesBundleTest extends EnumTypeMessagesBundleTest<KZTypeOfSettlement> {

    @Override
    protected KZTypeOfSettlement[] getAllEnumValues() {
	return KZTypeOfSettlement.values();
    }
}
