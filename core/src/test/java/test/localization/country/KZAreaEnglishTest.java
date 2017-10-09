package test.localization.country;

import com.lapsa.kz.country.KZArea;

import test.localization.ElementsLocalizationTest;

public class KZAreaEnglishTest extends ElementsLocalizationTest<KZArea> {

    public KZAreaEnglishTest() {
	super(KZArea.values(), KZArea.class, LOCALE_ENGLISH);
    }
}
