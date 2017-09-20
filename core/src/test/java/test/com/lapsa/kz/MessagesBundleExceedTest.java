package test.com.lapsa.kz;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

import com.lapsa.kz.LocalizedElement;
import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;
import com.lapsa.kz.country.KZCityType;
import com.lapsa.kz.country.KZTypeOfSettlement;
import com.lapsa.kz.economic.KZEconomicSector;

public class MessagesBundleExceedTest extends BaseMessagesBundleTest {

    @Test
    public void testNoExcessRecordsRussian() {
	Locale locale = getLocale(LANG_RU);
	ResourceBundle resources = getResourceBundle(LocalizedElement.BUNDLE_BASENAME, locale);
	assertThat(resources.getString("com.lapsa.kz.country.KZArea.GALM"),
		allOf(not(nullValue()), is("город Алматы")));
	testBundle(resources);
    }

    @Test
    public void testNoExcessRecordsKazakh() {
	Locale locale = getLocale(LANG_KK);
	ResourceBundle resources = getResourceBundle(LocalizedElement.BUNDLE_BASENAME, locale);
	assertThat(resources.getString("com.lapsa.kz.country.KZArea.GALM"),
		allOf(not(nullValue()), is("Алматы қаласы")));
	testBundle(resources);
    }

    @Test
    public void testNoExcessRecordsEnglish() {
	Locale locale = getLocale(LANG_EN);
	ResourceBundle resources = getResourceBundle(LocalizedElement.BUNDLE_BASENAME, locale);
	assertThat(resources.getString("com.lapsa.kz.country.KZArea.GALM"), allOf(not(nullValue()), is("Almaty city")));
	testBundle(resources);
    }

    private void testBundle(ResourceBundle resources) {
	Enumeration<String> keys = resources.getKeys();
	while (keys.hasMoreElements()) {
	    String key = keys.nextElement();
	    if (findByFullName(KZCity.values(), key) != null)
		continue;
	    if (findByFullName(KZArea.values(), key) != null)
		continue;
	    if (findByFullName(KZCityType.values(), key) != null)
		continue;
	    if (findByFullName(KZTypeOfSettlement.values(), key) != null)
		continue;
	    if (findByFullName(KZEconomicSector.values(), key) != null)
		continue;
	    fail(String.format("Resource bunddle key '%1$s' is not present", key));
	}
    }

    private <T extends Enum<?>> T findByFullName(T[] values, String key) {
	for (T c : values) {
	    String name = String.format("%s.%s", c.getClass().getName(), c.name());
	    if (name.equals(key))
		return c;
	    String shrt = String.format("%s.%s.short", c.getClass().getName(), c.name());
	    if (shrt.equals(key))
		return c;
	}
	return null;
    }
}
