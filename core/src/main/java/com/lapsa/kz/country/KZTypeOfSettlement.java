package com.lapsa.kz.country;

import com.lapsa.kz.LocalizedElement;

public enum KZTypeOfSettlement implements LocalizedElement {
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
