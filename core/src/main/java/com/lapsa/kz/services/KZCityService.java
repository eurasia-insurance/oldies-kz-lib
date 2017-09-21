package com.lapsa.kz.services;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;

public interface KZCityService extends NamingListingService<KZCity> {

    @Override
    default KZCity[] getAll() {
	return KZCity.values();
    }

    @Override
    default KZCity[] getSelectable() {
	return KZCity.selectableValues();
    }

    @Override
    default KZCity[] getNonSelectable() {
	return KZCity.nonSelectableValues();
    }

    default KZCity[] selectableByArea(KZArea area) {
	return KZCity.selectableValuesByArea(area);
    }

    default KZCity[] regionalByArea(KZArea area) {
	return KZCity.regionalValuesByArea(area);
    }
}
