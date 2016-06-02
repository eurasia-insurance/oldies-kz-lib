package com.lapsa.kz.country;

import com.lapsa.kz.KZLocalizationBundleBase;

public enum KZTypeOfSettlement implements KZLocalizationBundleBase {
    CITY, // город
    VILLAGE, // село
    AUL, // аул
    OTHER, // другое
    //
    ;
    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
