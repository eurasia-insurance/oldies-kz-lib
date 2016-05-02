package com.lapsa.kz.test.messages;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

import com.lapsa.kz.country.KZArea;

public class KZAreaMessagesBundleTest {

    @Test
    public void testRussianBundle() {
	ResourceBundle resources = ResourceBundle.getBundle(KZArea.BUNDLE_BASENAME, Locale.forLanguageTag("ru"));
	assertThat(resources, not(nullValue()));
	testBundle(resources);
    }

    @Test
    public void testKazakhBundle() {
	ResourceBundle resources = ResourceBundle.getBundle(KZArea.BUNDLE_BASENAME, Locale.forLanguageTag("ka"));
	assertThat(resources, not(nullValue()));
	testBundle(resources);
    }

    @Test
    public void testEnglishBundle() {
	ResourceBundle resources = ResourceBundle.getBundle(KZArea.BUNDLE_BASENAME, Locale.forLanguageTag("en"));
	assertThat(resources, not(nullValue()));
	testBundle(resources);
    }

    private void testBundle(ResourceBundle resources) {
	assertThat(resources, not(nullValue()));
	for (KZArea c : KZArea.values()) {
	    String name = resources.getString(String.format("%s.%s", c.getClass().getName(), c.name()));
	    assertThat(name, not(nullValue()));
	}
    }
}
