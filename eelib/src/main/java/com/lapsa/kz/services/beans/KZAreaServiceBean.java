package com.lapsa.kz.services.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.faces.services.FacesSelectItemService;
import com.lapsa.kz.country.KZArea;

@Named("kzAreaService")
@ApplicationScoped
public class KZAreaServiceBean implements FacesSelectItemService<KZArea> {

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
