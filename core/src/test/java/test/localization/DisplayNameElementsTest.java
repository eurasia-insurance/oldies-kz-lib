package test.localization;

import java.util.Locale;

import tech.lapsa.kz.DisplayNameElements;

public class DisplayNameElementsTest extends ElementsLocalizationTest<DisplayNameElements> {

    public DisplayNameElementsTest() {
	super(DisplayNameElements.values(), DisplayNameElements.class, Locale.getDefault());
    }

}
