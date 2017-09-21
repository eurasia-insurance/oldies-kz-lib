package com.lapsa.kz.services.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.faces.services.FacesSelectItemService;
import com.lapsa.kz.country.KZCity;
import com.lapsa.kz.services.KZCityService;

@Named("kzCityService")
@ApplicationScoped
public class KZCityServiceBean implements KZCityService, FacesSelectItemService<KZCity> {
}
