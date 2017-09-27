package com.lapsa.kz.faces.economic;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.faces.services.FacesSelectItemListingService;
import com.lapsa.kz.economic.KZEconomicSector;

@Named("kzEconomicSectorService")
@ApplicationScoped
public class KZEconomicSectorServiceBean implements FacesSelectItemListingService<KZEconomicSector> {

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
