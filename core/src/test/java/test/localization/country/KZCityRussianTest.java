package test.localization.country;

import com.lapsa.kz.country.KZCity;

import test.localization.ElementsLocalizationTest;

public class KZCityRussianTest extends ElementsLocalizationTest<KZCity> {

    public KZCityRussianTest() {
	super(KZCity.values(), KZCity.class, LOCALE_RUSSIAN);
    }
}
