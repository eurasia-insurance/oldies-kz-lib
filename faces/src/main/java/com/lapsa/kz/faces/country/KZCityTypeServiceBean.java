package com.lapsa.kz.faces.country;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import com.lapsa.faces.services.FacesSelectItemListingService;
import com.lapsa.kz.country.KZCityType;

@Named("kzAreaService")
@ApplicationScoped
public class KZCityTypeServiceBean implements FacesSelectItemListingService<KZCityType> {

    @Override
    public KZCityType[] getAll() {
	return KZCityType.values();
    }

    @Override
    public KZCityType[] getSelectable() {
	return KZCityType.selectableValues();
    }

    @Override
    public KZCityType[] getNonSelectable() {
	return KZCityType.nonSelectableValues();
    }

    public KZCityType[] getRegional() {
	return KZCityType.regionalValues();
    }

    //

    public List<SelectItem> getRegionalSI() {
	return generateItemsSI(this::getRegional, this::selectItem);
    }

    public List<SelectItem> getRegionalShortSI() {
	return generateItemsSI(this::getRegional, this::selectItemShort);
    }

    public List<SelectItem> getRegionalFullSI() {
	return generateItemsSI(this::getRegional, this::selectItemFull);
    }
}
