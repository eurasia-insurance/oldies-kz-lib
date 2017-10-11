package com.lapsa.kz.country;

import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum KZCityType implements LocalizedElement {
    MAJOR(true), // 1 - город республиканского значения
    REGIONAL_CENTER(true), // 2 — областной центр
    REGIONAL_SUBORDINATION(true), // 3 — город областного подчинения
    DISTINCT_CENTER, // 4 — районный центр
    DISTINCT_SUBORDINATION, // 5 — город районного подчинения
    UNDEFINED(false, false), // не определено
    ;

    //

    private final boolean selectable;
    private final boolean regional;

    //

    private KZCityType() {
	this.regional = false;
	this.selectable = true;
    }

    private KZCityType(boolean regional) {
	this.regional = regional;
	this.selectable = true;
    }

    private KZCityType(boolean regional, boolean selectable) {
	this.regional = regional;
	this.selectable = selectable;
    }

    //

    public static final KZCityType[] regionalValues() {
	return Stream.of(values()) //
		.filter(KZCityType::isRegional) //
		.toArray(KZCityType[]::new);
    }

    //

    public static final Stream<KZCityType> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<KZCityType> SELECTABLE_FILTER = KZCityType::isSelectable;

    public static final KZCityType[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(KZCityType[]::new);
    }

    //

    private static final Predicate<KZCityType> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final KZCityType[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(KZCityType[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }

    public boolean isRegional() {
	return regional;
    }
}
