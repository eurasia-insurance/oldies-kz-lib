package test.localization.vehicle;

import java.util.Locale;

import tech.lapsa.kz.vehicle.RegNumberType;
import test.localization.ElementsLocalizationTest;

public class RegNumberTypeTest extends ElementsLocalizationTest<RegNumberType> {

    public RegNumberTypeTest() {
	super(RegNumberType.values(), RegNumberType.class, Locale.getDefault());
    }

}
