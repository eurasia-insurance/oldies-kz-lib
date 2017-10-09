package test.localization.country;

import com.lapsa.kz.country.KZArea;

import test.localization.ElementsLocalizationTest;

public class KZAreaRussianTest extends ElementsLocalizationTest<KZArea> {

    public KZAreaRussianTest() {
	super(KZArea.values(), KZArea.class, LOCALE_RUSSIAN);
    }
}
