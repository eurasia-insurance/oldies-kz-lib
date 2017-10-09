package test.localization.country;

import com.lapsa.kz.country.KZArea;

import test.localization.ElementsLocalizationTest;

public class KZAreaKazakhTest extends ElementsLocalizationTest<KZArea> {

    public KZAreaKazakhTest() {
	super(KZArea.values(), KZArea.class, LOCALE_KAZAKH);
    }
}
