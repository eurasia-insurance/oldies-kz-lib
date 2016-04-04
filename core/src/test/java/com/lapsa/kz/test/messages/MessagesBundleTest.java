package com.lapsa.kz.test.messages;

import static com.lapsa.kz.test.messages.TestConstants.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;
import com.lapsa.kz.country.KZCityType;
import com.lapsa.kz.economic.KZEconomicSector;

public class MessagesBundleTest {

    @Test
    public void testNoExcessRecords() {
	ResourceBundle resources = ResourceBundle.getBundle(MESSAGES_BUNDLE_BASENAME, Locale.forLanguageTag("ru"));
	assertThat(resources, not(nullValue()));
	Enumeration<String> keys = resources.getKeys();
	while (keys.hasMoreElements()) {
	    String key = keys.nextElement();
	    KZCity city = findByFullName(KZCity.values(), key);
	    if (city != null)
		continue;
	    KZArea area = findByFullName(KZArea.values(), key);
	    if (area != null)
		continue;
	    KZCityType cityType = findByFullName(KZCityType.values(), key);
	    if (cityType == null)
		continue;
	    KZEconomicSector economicSector = findByFullName(KZEconomicSector.values(), key);
	    if (economicSector == null)
		continue;
	    fail(String.format("Resource bunddle key '%1$s' is not present", key));
	}
    }

    private <T extends Enum<?>> T findByFullName(T[] values, String key) {
	for (T c : values) {
	    String name = String.format("%s.%s", c.getClass().getName(), c.name());
	    if (name.equals(key))
		return c;
	}
	return null;
    }
}
