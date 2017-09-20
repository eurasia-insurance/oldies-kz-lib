package com.lapsa.kz;

import com.lapsa.commons.elements.LocalizedElement;

public interface KZLocalizedElement extends LocalizedElement {

    public static final String BUNDLE_BASENAME = "KZLocalization";

    @Override
    default String getBundleBaseName() {
	return BUNDLE_BASENAME;
    }
}
