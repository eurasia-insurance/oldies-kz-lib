package tech.lapsa.kz;

import java.util.Locale;
import java.util.function.Function;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum DisplayNameElements implements LocalizedElement {
    AREA,
    TYPE,
    VEHICLE_TYPE,
    ENTITY_TYPE
    ;

    public Function<String, String> fieldAsCaptionMapper(final LocalizationVariant variant,
	    final Locale locale) {
	return x -> localized(variant, locale) + " '" + x + "'";
    }
}
