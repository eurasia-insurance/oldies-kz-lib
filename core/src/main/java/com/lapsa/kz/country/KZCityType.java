package com.lapsa.kz.country;

public enum KZCityType {
    MAJOR, // 1 - город республиканского значения
    REGIONAL_CENTER, // 2 — областной центр
    REGIONAL_SUBORDINATION, // 3 — город областного подчинения
    DISTINCT_CENTER, // 4 — районный центр
    DISTINCT_SUBORDINATION, // 5 — город районного подчинения
    ;

    public static final String BUNDLE_BASENAME = "KZLibLocalization";
}
