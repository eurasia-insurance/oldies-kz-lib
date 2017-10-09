package test.localization.country;

import com.lapsa.kz.country.KZCityType;

import test.localization.ElementsLocalizationTest;

public class KZCityTypeRussianTest extends ElementsLocalizationTest<KZCityType> {

    public KZCityTypeRussianTest() {
	super(KZCityType.values(), KZCityType.class, LOCALE_RUSSIAN);
    }
}
