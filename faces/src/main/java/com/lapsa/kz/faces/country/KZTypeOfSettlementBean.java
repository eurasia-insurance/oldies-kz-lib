package com.lapsa.kz.faces.country;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.kz.country.KZTypeOfSettlement;

import tech.lapsa.javax.faces.beans.localization.ListingBean;

@Named("KZTypeOfSettlement")
@ApplicationScoped
public class KZTypeOfSettlementBean implements ListingBean<KZTypeOfSettlement> {

    @Override
    public KZTypeOfSettlement[] getAll() {
	return KZTypeOfSettlement.values();
    }

    @Override
    public KZTypeOfSettlement[] getSelectable() {
	return KZTypeOfSettlement.selectableValues();
    }

    @Override
    public KZTypeOfSettlement[] getNonSelectable() {
	return KZTypeOfSettlement.nonSelectableValues();
    }
}
