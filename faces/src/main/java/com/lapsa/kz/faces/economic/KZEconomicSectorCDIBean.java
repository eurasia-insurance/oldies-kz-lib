package com.lapsa.kz.faces.economic;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.kz.economic.KZEconomicSector;

import tech.lapsa.javax.faces.commons.beans.localization.ListingBean;

@Named("KZEconomicSector")
@ApplicationScoped
public class KZEconomicSectorCDIBean implements ListingBean<KZEconomicSector> {

    @Override
    public KZEconomicSector[] getAll() {
	return KZEconomicSector.values();
    }

    @Override
    public KZEconomicSector[] getSelectable() {
	return KZEconomicSector.selectableValues();
    }

    @Override
    public KZEconomicSector[] getNonSelectable() {
	return KZEconomicSector.nonSelectableValues();
    }

    @Override
    public KZEconomicSector byName(String name) {
	return KZEconomicSector.valueOf(name);
    }
}
