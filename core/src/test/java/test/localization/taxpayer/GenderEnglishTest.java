package test.localization.taxpayer;

import tech.lapsa.kz.taxpayer.Gender;
import test.localization.ElementsLocalizationTest;

public class GenderEnglishTest extends ElementsLocalizationTest<Gender> {

    public GenderEnglishTest() {
	super(Gender.values(), Gender.class, LOCALE_ENGLISH);
    }
}
