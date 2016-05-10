package com.lapsa.kz.idnumber;

public abstract class IDNumberValidatorProvider {

    private final static IDNumberValidator INSTANCE = new DefaultIDNumberValidator();

    public final static IDNumberValidator provideDefault() {
	return INSTANCE;
    }
}
