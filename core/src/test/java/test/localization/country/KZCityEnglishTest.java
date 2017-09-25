package test.localization.country;

import com.lapsa.kz.country.KZCity;

import test.localization.ElementsLocalizationTest;

public class KZCityEnglishTest extends ElementsLocalizationTest<KZCity> {

    public KZCityEnglishTest() {
	super(KZCity.values(), KZCity.class, LOCALE_ENGLISH);
    }
}
