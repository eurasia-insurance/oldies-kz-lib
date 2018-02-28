package com.lapsa.kz.country;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.localization.LocalizedElement;

public enum KZArea implements LocalizedElement {
    GAST("01", "Z"), // Астана - код 01
    GALM("02", "A"), // Алматы - код 02
    OAKM("03", "C", "O", "W"), // Акмолинская область - код 03
    OAKT("04", "D"), // Актюбинская область - код 04
    OALM("05", "B", "V"), // Алматинская область - код 05
    OATY("06", "E"), // Атырауская область - код 06
    OZK("07", "L"), // Западно-Казахстанская область - код 07
    OZHM("08", "H"), // Жамбылская область - код 08
    OKGD("09", "M", "K"), // Карагандинская область - код 09
    OKST("10", "P", "W"), // Костанайская область - код 10
    OKZL("11", "N"), // Кызылординская область - код 11
    OMNG("12", "R"), // Мангистауская область - код 12
    OUK("13", "X"), // Южно-Казахстанская область - код 13
    OPVL("14", "S"), // Павлодарская область - код 14
    OSK("15", "T", "O"), // Северо-Казахстанская область - код 15
    OVK("16", "F", "U"), // Восточно-Казахстанская область - код 16
    UNDEFINED("-", false),
    ;

    //

    private final boolean selectable;
    private final String code;
    private final String[] autoCodes;

    //

    private KZArea(final String code, final String... autoCodes) {
	this.code = MyObjects.requireNonNull(code);
	selectable = true;
	this.autoCodes = autoCodes;
    }

    private KZArea(final String code, final boolean selectable, final String... autoCodes) {
	this.code = MyObjects.requireNonNull(code);
	this.selectable = selectable;
	this.autoCodes = autoCodes;
    }

    //

    public static final Stream<KZArea> valuesStream() {
	return Stream.of(values());
    }

    //

    public static KZArea getForCode(final String code) {
	return optionalForCode(code) //
		.orElse(null);
    }

    public static Optional<KZArea> optionalForCode(final String code) {
	return Stream.of(values()) //
		.filter(x -> x.code.equals(code)) //
		.findAny();
    }

    public static KZArea getForAutoCode(final String autoCode) {
	return optionalForAutoCode(autoCode)
		.orElse(null);
    }

    public static Optional<KZArea> optionalForAutoCode(final String autoCode) {
	return Stream.of(values()) //
		.filter(x -> x.code.equals(autoCode)
			|| Stream.of(x.autoCodes).anyMatch(y -> y.equalsIgnoreCase(autoCode))) //
		.findAny();
    }

    public static void main(final String[] args) {
	System.out.println(KZArea.optionalForAutoCode("O"));
    }

    //

    private static final Predicate<KZArea> SELECTABLE_FILTER = KZArea::isSelectable;

    public static final KZArea[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(KZArea[]::new);
    }

    //

    private static final Predicate<KZArea> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final KZArea[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(KZArea[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }

    public String getCode() {
	return code;
    }

    public boolean in(KZArea... areas) {
	for (KZArea a : areas)
	    if (a.equals(this))
		return true;
	return false;
    }
}
