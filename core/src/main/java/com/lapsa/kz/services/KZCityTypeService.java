package com.lapsa.kz.services;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.kz.country.KZCityType;

public interface KZCityTypeService extends NamingListingService<KZCityType> {

    @Override
    default KZCityType[] getAll() {
	return KZCityType.values();
    }

    @Override
    default KZCityType[] getSelectable() {
	return KZCityType.values();
    }

    @Override
    default KZCityType[] getNonSelectable() {
	return new KZCityType[0];
    }

    default KZCityType[] getRegional() {
	return KZCityType.regionalValues();
    }
}
