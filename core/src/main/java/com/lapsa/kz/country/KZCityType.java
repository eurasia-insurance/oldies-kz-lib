package com.lapsa.kz.country;

import java.util.stream.Stream;

import com.lapsa.kz.KZLocalizedElement;

public enum KZCityType implements KZLocalizedElement {
    MAJOR(true), // 1 - город республиканского значения
    REGIONAL_CENTER(true), // 2 — областной центр
    REGIONAL_SUBORDINATION(true), // 3 — город областного подчинения
    DISTINCT_CENTER, // 4 — районный центр
    DISTINCT_SUBORDINATION, // 5 — город районного подчинения
    //
    ;

    private final boolean regional;

    //

    private KZCityType() {
	this.regional = false;
    }

    private KZCityType(boolean regional) {
	this.regional = regional;
    }

    //

    public static final KZCityType[] regionalValues() {
	return Stream.of(values()) //
		.filter(KZCityType::isRegional) //
		.toArray(KZCityType[]::new);
    }

    // GENERATED

    public boolean isRegional() {
	return regional;
    }
}
