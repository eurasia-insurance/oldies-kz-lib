package tech.lapsa.kz;

import java.util.Locale;
import java.util.function.Function;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum DisplayNameElements implements LocalizedElement {
    VEHICLE_AREA,
    VEHICLE_REG_NUMBER_TYPE,
    VEHICLE_TYPE,
    VEHICLE_ENTITY_TYPE,
    TAXPAYER_NUMBER_DATE_OF_BIRTH,
    TAXPAYER_NUMBER_GENDER;

    public Function<String, String> fieldAsCaptionMapper(final LocalizationVariant variant,
	    final Locale locale) {
	return x -> localized(variant, locale) + " '" + x + "'";
    }
}
