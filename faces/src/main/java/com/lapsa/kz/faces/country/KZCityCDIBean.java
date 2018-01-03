package com.lapsa.kz.faces.country;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;

import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.javax.faces.commons.beans.localization.ListingBean;

@Named("KZCity")
@ApplicationScoped
public class KZCityCDIBean implements ListingBean<KZCity> {

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

    public KZCity[] selectableByArea(final KZArea area) {
	return KZCity.selectableValuesByArea(area);
    }

    public KZCity[] selectableByAreaOrAll(final KZArea area) {
	return KZCity.selectableValuesByArea(MyOptionals.of(area));
    }

    public KZCity[] regionalByArea(final KZArea area) {
	return KZCity.regionalValuesByArea(area);
    }

    public KZCity[] regionalByAreaOrAll(final KZArea area) {
	return KZCity.regionalValuesByArea(MyOptionals.of(area));
    }
}
