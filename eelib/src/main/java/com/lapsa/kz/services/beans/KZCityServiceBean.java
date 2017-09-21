package com.lapsa.kz.services.beans;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import com.lapsa.faces.services.FacesSelectItemService;
import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;
import com.lapsa.kz.services.KZCityService;

@Named("kzCityService")
@ApplicationScoped
public class KZCityServiceBean implements KZCityService, FacesSelectItemService<KZCity> {

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
