package com.lapsa.kz.faces.country;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.kz.country.KZCityType;

import tech.lapsa.javax.faces.commons.beans.localization.ListingBean;

@Named("KZCityType")
@ApplicationScoped
public class KZCityTypeCDIBean implements ListingBean<KZCityType> {

    @Override
    public KZCityType[] getAll() {
	return KZCityType.values();
    }

    @Override
    public KZCityType[] getSelectable() {
	return KZCityType.selectableValues();
    }

    @Override
    public KZCityType[] getNonSelectable() {
	return KZCityType.nonSelectableValues();
    }

    public KZCityType[] getRegional() {
	return KZCityType.regionalValues();
    }
}
