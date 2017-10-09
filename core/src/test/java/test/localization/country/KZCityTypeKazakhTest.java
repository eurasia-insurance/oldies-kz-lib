package test.localization.country;

import com.lapsa.kz.country.KZCityType;

import test.localization.ElementsLocalizationTest;

public class KZCityTypeKazakhTest extends ElementsLocalizationTest<KZCityType> {

    public KZCityTypeKazakhTest() {
	super(KZCityType.values(), KZCityType.class, LOCALE_KAZAKH);
    }
}
