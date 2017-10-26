package test.localization.vehicle;

import java.util.Locale;

import tech.lapsa.kz.vehicle.DisplayNameElements;
import test.localization.ElementsLocalizationTest;

public class DisplayNameElementsTest extends ElementsLocalizationTest<DisplayNameElements> {

    public DisplayNameElementsTest() {
	super(DisplayNameElements.values(), DisplayNameElements.class, Locale.getDefault());
    }

}
