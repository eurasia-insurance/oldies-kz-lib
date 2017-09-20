package test.com.lapsa.kz;

import com.lapsa.kz.country.KZCityType;

public class KZCityTypeMessagesBundleTest extends EnumTypeMessagesBundleTest<KZCityType> {

    @Override
    protected KZCityType[] getAllEnumValues() {
	return KZCityType.values();
    }
}
