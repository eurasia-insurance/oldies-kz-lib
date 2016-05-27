package com.lapsa.kz.country;

import com.lapsa.kz.KZLocalizationBundleBase;

public enum KZCityType implements KZLocalizationBundleBase {
    MAJOR, // 1 - город республиканского значения
    REGIONAL_CENTER, // 2 — областной центр
    REGIONAL_SUBORDINATION, // 3 — город областного подчинения
    DISTINCT_CENTER, // 4 — районный центр
    DISTINCT_SUBORDINATION, // 5 — город районного подчинения
    //
    ;

    @Override
    public String canonicalName() {
    	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
