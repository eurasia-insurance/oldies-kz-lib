package com.lapsa.kz.country;

import java.util.function.Predicate;
import java.util.stream.Stream;

import com.lapsa.kz.KZLocalizedElement;

public enum KZArea implements KZLocalizedElement {
    GAST("01"), // Астана - код 01
    GALM("02"), // Алматы - код 02
    OAKM("03"), // Акмолинская область - код 03
    OAKT("04"), // Актюбинская область - код 04
    OALM("05"), // Алматинская область - код 05
    OATY("06"), // Атырауская область - код 06
    OZK("07"), // Западно-Казахстанская область - код 07
    OZHM("08"), // Жамбылская область - код 08
    OKGD("09"), // Карагандинская область - код 09
    OKST("10"), // Костанайская область - код 10
    OKZL("11"), // Кызылординская область - код 11
    OMNG("12"), // Мангистауская область - код 12
    OUK("13"), // Южно-Казахстанская область - код 13
    OPVL("14"), // Павлодарская область - код 14
    OSK("15"), // Северо-Казахстанская область - код 15
    OVK("16"), // Восточно-Казахстанская область - код 16
    UNDEFINED(false),
    //
    ;

    private final String code;
    private final boolean selectable;

    //

    private KZArea(String code) {
	this.code = code;
	this.selectable = true;
    }

    private KZArea(boolean selectable) {
	this.code = null;
	this.selectable = selectable;
    }

    //

    public static KZArea forCode(String code) {
	return Stream.of(values()) //
		.filter(x -> x.code == code) //
		.findAny() //
		.orElse(null);
    }

    //

    private static final Predicate<KZArea> SELECTABLE_FILTER = KZArea::isSelectable;

    public static final KZArea[] selectableValues() {
	return Stream.of(values()) //
		.filter(SELECTABLE_FILTER) //
		.toArray(KZArea[]::new);
    }

    //

    private static final Predicate<KZArea> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final KZArea[] nonSelectableValues() {
	return Stream.of(values()) //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(KZArea[]::new);
    }

    // GENERATED

    public String getCode() {
	return code;
    }

    public boolean isSelectable() {
	return selectable;
    }
}
