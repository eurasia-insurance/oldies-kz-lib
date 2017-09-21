package com.lapsa.kz.services.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.faces.services.FacesSelectItemService;
import com.lapsa.kz.country.KZTypeOfSettlement;
import com.lapsa.kz.services.KZTypeOfSettlementService;

@Named("kzTypeOfSettlementService")
@ApplicationScoped
public class KZTypeOfSettlementServiceBean
	implements KZTypeOfSettlementService, FacesSelectItemService<KZTypeOfSettlement> {
}
