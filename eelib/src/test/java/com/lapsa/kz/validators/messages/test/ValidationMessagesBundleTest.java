package com.lapsa.kz.validators.messages.test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class ValidationMessagesBundleTest {

    @Test
    public void testNoExcessRecordsRussian() {
	final Locale locale = Locale.forLanguageTag(Constants.LANGUAGE_TAG_RUSSIAN);
	assertThat(locale.getLanguage(), allOf(not(nullValue()), is(Constants.LANGUAGE_TAG_RUSSIAN)));
	final ResourceBundle resources = ResourceBundle.getBundle(Constants.VALIDATION_MESSAGES_BUNDLE_BASE_NAME,
		locale);
	assertThat(resources, not(nullValue()));
	testBundle(resources);
    }

    @Test
    public void testNoExcessRecordsKazakh() {
	final Locale locale = Locale.forLanguageTag(Constants.LANGUAGE_TAG_KAZAKH);
	assertThat(locale.getLanguage(), allOf(not(nullValue()), is(Constants.LANGUAGE_TAG_KAZAKH)));
	final ResourceBundle resources = ResourceBundle.getBundle(Constants.VALIDATION_MESSAGES_BUNDLE_BASE_NAME,
		locale);
	assertThat(resources, not(nullValue()));
	testBundle(resources);
    }

    @Test
    public void testNoExcessRecordsEnglish() {
	final Locale locale = Locale.ENGLISH;
	assertThat(locale.getLanguage(), allOf(not(nullValue()), is(Constants.LANGUAGE_TAG_ENGLISH)));
	final ResourceBundle resources = ResourceBundle.getBundle(Constants.VALIDATION_MESSAGES_BUNDLE_BASE_NAME,
		locale);
	assertThat(resources, not(nullValue()));
	testBundle(resources);
    }

    private void testBundle(final ResourceBundle resources) {
	final Enumeration<String> keys = resources.getKeys();
	while (keys.hasMoreElements()) {
	    final String key = keys.nextElement();
	    assertThat(String.format("Validation messages key must ends with '%1$s'", Constants.KEY_SUFFIX), key,
		    endsWith(Constants.KEY_SUFFIX));
	    final String className = key.substring(0, key.length() - Constants.KEY_SUFFIX.length());
	    Class<?> cls = null;
	    try {
		cls = Class.forName(className);
	    } catch (final ClassNotFoundException e) {
		fail(String.format("Not found class for name '%1$s' of resource bundle", className));
	    }
	    if (!cls.isAnnotation())
		fail(String.format("Class '%1$s' is not annotation", cls.getName()));
	}
    }
}
