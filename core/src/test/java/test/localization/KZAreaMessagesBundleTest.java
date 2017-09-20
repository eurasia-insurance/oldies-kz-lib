package test.localization;

import com.lapsa.kz.country.KZArea;

public class KZAreaMessagesBundleTest extends EnumTypeMessagesBundleTest<KZArea> {

    @Override
    protected KZArea[] getAllEnumValues() {
	return KZArea.values();
    }
}
