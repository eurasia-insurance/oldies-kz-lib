package test.localization.country;

import com.lapsa.kz.country.KZCity;

import test.localization.ElementsLocalizationTest;

public class KZCityKazakhTest extends ElementsLocalizationTest<KZCity> {

    public KZCityKazakhTest() {
	super(KZCity.values(), KZCity.class, LOCALE_KAZAKH);
    }
}
