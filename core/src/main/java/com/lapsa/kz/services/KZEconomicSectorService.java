package com.lapsa.kz.services;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.kz.economic.KZEconomicSector;

public interface KZEconomicSectorService extends NamingListingService<KZEconomicSector> {

    @Override
    default KZEconomicSector[] getAll() {
	return KZEconomicSector.values();
    }

    @Override
    default KZEconomicSector[] getSelectable() {
	return KZEconomicSector.selectableValues();
    }

    @Override
    default KZEconomicSector[] getNonSelectable() {
	return KZEconomicSector.nonSelectableValues();
    }
}
