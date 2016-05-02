package com.lapsa.kz.test.messages;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

import com.lapsa.kz.BundleBase;
import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;
import com.lapsa.kz.country.KZCityType;
import com.lapsa.kz.economic.KZEconomicSector;

public class MessagesBundleTest {

    @Test
    public void testNoExcessRecordsRussian() {
	Locale locale = Locale.forLanguageTag("ru");
	assertThat(locale.getLanguage(), allOf(not(nullValue()), is("ru")));
	ResourceBundle resources = ResourceBundle.getBundle(BundleBase.BUNDLE_BASENAME, locale);
	assertThat(resources, not(nullValue()));
	assertThat(resources.getString("com.lapsa.kz.country.KZArea.GALM"),
		allOf(not(nullValue()), is("город Алматы")));
	testBundle(resources);
    }

    @Test
    public void testNoExcessRecordsKazakh() {
	Locale locale = Locale.forLanguageTag("kk");
	assertThat(locale.getLanguage(), allOf(not(nullValue()), is("kk")));
	ResourceBundle resources = ResourceBundle.getBundle(BundleBase.BUNDLE_BASENAME, locale);
	assertThat(resources, not(nullValue()));
	assertThat(resources.getString("com.lapsa.kz.country.KZArea.GALM"),
		allOf(not(nullValue()), is("Алматы қаласы")));
	testBundle(resources);
    }

    @Test
    public void testNoExcessRecordsEnglish() {
	Locale locale = Locale.forLanguageTag("en");
	assertThat(locale.getLanguage(), allOf(not(nullValue()), is("en")));
	ResourceBundle resources = ResourceBundle.getBundle(BundleBase.BUNDLE_BASENAME, locale);
	assertThat(resources, not(nullValue()));
	assertThat(resources.getString("com.lapsa.kz.country.KZArea.GALM"), allOf(not(nullValue()), is("Almaty")));
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
	}
	return null;
    }
}
