package com.lapsa.kz.services.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.faces.services.FacesSelectItemService;
import com.lapsa.kz.economic.KZEconomicSector;
import com.lapsa.kz.services.KZEconomicSectorService;

@Named("kzEconomicSectorService")
@ApplicationScoped
public class KZEconomicSectorServiceBean implements KZEconomicSectorService, FacesSelectItemService<KZEconomicSector> {
}
