package com.lapsa.kz.services.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.faces.services.FacesSelectItemService;
import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.services.KZAreaService;

@Named("kzAreaService")
@ApplicationScoped
public class KZCityTypeServiceBean implements KZAreaService, FacesSelectItemService<KZArea> {
}
