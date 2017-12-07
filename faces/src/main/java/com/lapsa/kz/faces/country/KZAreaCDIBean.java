package com.lapsa.kz.faces.country;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.kz.country.KZArea;

import tech.lapsa.javax.faces.commons.beans.localization.ListingBean;

@Named("KZArea")
@ApplicationScoped
public class KZAreaCDIBean implements ListingBean<KZArea> {

    @Override
    public KZArea[] getAll() {
	return KZArea.values();
    }

    @Override
    public KZArea[] getSelectable() {
	return KZArea.selectableValues();
    }

    @Override
    public KZArea[] getNonSelectable() {
	return KZArea.nonSelectableValues();
    }
}
