package com.lapsa.kz.faces.country;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.faces.services.FacesSelectItemListingService;
import com.lapsa.kz.country.KZArea;

@Named("kzAreaService")
@ApplicationScoped
public class KZAreaServiceBean implements FacesSelectItemListingService<KZArea> {

    @Override
    public KZArea[] getAll() {
	return KZArea.values();
    }

    @Override
    public KZArea[] getSelectable() {
	return KZArea.selectableValues();
    }

    @Override
    public KZArea[] getNonSelectable() {
	return KZArea.nonSelectableValues();
    }
}
