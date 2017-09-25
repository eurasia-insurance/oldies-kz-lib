package com.lapsa.kz.services.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.faces.services.FacesSelectItemService;
import com.lapsa.kz.country.KZTypeOfSettlement;

@Named("kzTypeOfSettlementService")
@ApplicationScoped
public class KZTypeOfSettlementServiceBean implements FacesSelectItemService<KZTypeOfSettlement> {

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
