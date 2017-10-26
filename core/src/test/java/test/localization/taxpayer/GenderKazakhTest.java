package test.localization.taxpayer;

import tech.lapsa.kz.taxpayer.Gender;
import test.localization.ElementsLocalizationTest;

public class GenderKazakhTest extends ElementsLocalizationTest<Gender> {

    public GenderKazakhTest() {
	super(Gender.values(), Gender.class, LOCALE_KAZAKH);
    }
}
