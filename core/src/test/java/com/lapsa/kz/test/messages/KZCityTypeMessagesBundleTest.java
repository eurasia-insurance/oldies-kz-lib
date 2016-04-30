package com.lapsa.kz.test.messages;

import static com.lapsa.kz.test.messages.TestConstants.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

import com.lapsa.kz.country.KZCityType;

public class KZCityTypeMessagesBundleTest {

    @Test
    public void testRussianBundle() {
	ResourceBundle resources = ResourceBundle.getBundle(MESSAGES_BUNDLE_BASENAME, Locale.forLanguageTag("ru"));
	testBundle(resources);
    }

    @Test
    public void testKazakhBundle() {
	ResourceBundle resources = ResourceBundle.getBundle(MESSAGES_BUNDLE_BASENAME, Locale.forLanguageTag("ka"));
	testBundle(resources);
    }

    @Test
    public void testEnglishBundle() {
	ResourceBundle resources = ResourceBundle.getBundle(MESSAGES_BUNDLE_BASENAME, Locale.forLanguageTag("en"));
	testBundle(resources);
    }

    private void testBundle(ResourceBundle resources) {
	assertThat(resources, not(nullValue()));
	for (KZCityType c : KZCityType.values()) {
	    String name = resources.getString(String.format("%s.%s", c.getClass().getName(), c.name()));
	    assertThat(name, not(nullValue()));
	}
    }
}
