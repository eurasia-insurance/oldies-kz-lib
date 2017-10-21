package com.lapsa.kz.faces.country;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import com.lapsa.faces.services.FacesSelectItemListingService;
import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;

@Named("kzCityService")
@ApplicationScoped
public class KZCityServiceBean implements FacesSelectItemListingService<KZCity> {

    @Override
    public KZCity[] getAll() {
	return KZCity.values();
    }

    @Override
    public KZCity[] getSelectable() {
	return KZCity.selectableValues();
    }

    @Override
    public KZCity[] getNonSelectable() {
	return KZCity.nonSelectableValues();
    }

    public KZCity[] selectableByArea(KZArea area) {
	return KZCity.selectableValuesByArea(area);
    }

    public KZCity[] regionalByArea(KZArea area) {
	return KZCity.regionalValuesByArea(area);
    }
    
    //

    public List<SelectItem> selectableByAreaSI(KZArea area) {
	return generateItemsSI(() -> selectableByArea(area), this::selectItem);
    }

    public List<SelectItem> selectableByAreaShortSI(KZArea area) {
	return generateItemsSI(() -> selectableByArea(area), this::selectItemShort);
    }

    public List<SelectItem> selectableByAreaFullSI(KZArea area) {
	return generateItemsSI(() -> selectableByArea(area), this::selectItemFull);
    }

    //

    public List<SelectItem> regionalByAreaSI(KZArea area) {
	return generateItemsSI(() -> regionalByArea(area), this::selectItem);
    }

    public List<SelectItem> regionalByAreaShortSI(KZArea area) {
	return generateItemsSI(() -> regionalByArea(area), this::selectItemShort);
    }

    public List<SelectItem> regionalByAreaFullSI(KZArea area) {
	return generateItemsSI(() -> regionalByArea(area), this::selectItemFull);
    }
}
