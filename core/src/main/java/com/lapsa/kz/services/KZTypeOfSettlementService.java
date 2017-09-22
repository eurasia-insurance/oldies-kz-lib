
package com.lapsa.kz.services;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.kz.country.KZTypeOfSettlement;

public interface KZTypeOfSettlementService extends NamingListingService<KZTypeOfSettlement> {

    @Override
    default KZTypeOfSettlement[] getAll() {
	return KZTypeOfSettlement.values();
    }

    @Override
    default KZTypeOfSettlement[] getSelectable() {
	return KZTypeOfSettlement.selectableValues();
    }

    @Override
    default KZTypeOfSettlement[] getNonSelectable() {
	return KZTypeOfSettlement.nonSelectableValues();
    }
}
