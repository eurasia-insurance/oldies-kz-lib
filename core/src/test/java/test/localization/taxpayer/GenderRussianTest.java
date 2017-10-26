package test.localization.taxpayer;

import tech.lapsa.kz.taxpayer.Gender;
import test.localization.ElementsLocalizationTest;

public class GenderRussianTest extends ElementsLocalizationTest<Gender> {

    public GenderRussianTest() {
	super(Gender.values(), Gender.class, LOCALE_RUSSIAN);
    }
}
