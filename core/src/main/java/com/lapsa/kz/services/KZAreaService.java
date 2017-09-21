package com.lapsa.kz.services;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.kz.country.KZArea;

public interface KZAreaService extends NamingListingService<KZArea> {

    @Override
    default KZArea[] getAll() {
	return KZArea.values();
    }

    @Override
    default KZArea[] getSelectable() {
	return KZArea.selectableValues();
    }

    @Override
    default KZArea[] getNonSelectable() {
	return KZArea.nonSelectableValues();
    }
}
