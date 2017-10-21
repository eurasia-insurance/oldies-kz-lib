package com.lapsa.kz.faces.country;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;

import tech.lapsa.javax.faces.beans.localization.ListingBean;

@Named("kzCity")
@ApplicationScoped
public class KZCityBean implements ListingBean<KZCity> {

    @Override
    public KZCity[] getAll() {
	return KZCity.values();
    }

    @Override
    public KZCity[] getSelectable() {
	return KZCity.selectableValues();
    }

    @Override
    public KZCity[] getNonSelectable() {
	return KZCity.nonSelectableValues();
    }

    public KZCity[] selectableByArea(KZArea area) {
	return KZCity.selectableValuesByArea(area);
    }

    public KZCity[] regionalByArea(KZArea area) {
	return KZCity.regionalValuesByArea(area);
    }
}
