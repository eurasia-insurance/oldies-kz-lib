package com.lapsa.kz.services.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.faces.services.FacesSelectItemService;
import com.lapsa.kz.economic.KZEconomicSector;

@Named("kzEconomicSectorService")
@ApplicationScoped
public class KZEconomicSectorServiceBean implements FacesSelectItemService<KZEconomicSector> {

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
}
