package test.localization.country;

import com.lapsa.kz.country.KZCityType;

import test.localization.ElementsLocalizationTest;

public class KZCityTypeEnglishTest extends ElementsLocalizationTest<KZCityType> {

    public KZCityTypeEnglishTest() {
	super(KZCityType.values(), KZCityType.class, LOCALE_ENGLISH);
    }
}
