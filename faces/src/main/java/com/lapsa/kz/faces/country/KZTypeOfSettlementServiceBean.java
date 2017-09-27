package com.lapsa.kz.faces.country;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.faces.services.FacesSelectItemListingService;
import com.lapsa.kz.country.KZTypeOfSettlement;

@Named("kzTypeOfSettlementService")
@ApplicationScoped
public class KZTypeOfSettlementServiceBean implements FacesSelectItemListingService<KZTypeOfSettlement> {

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
