package com.lapsa.kz.economic;

import com.lapsa.kz.BundleBase;

public enum KZEconomicSector implements BundleBase {
    GOVERNMENT("1"), // Правительство Республики Казахстан
    ADMINISTRATION("2"), // Региональные и местные органы управления
    CENTRAL_BANK("3"), // Национальный банк РК и Центральные Банки других
		       // стран
    DEPOSITORY("4"), // Другие депозитные организации
    FINANCIAL("5"), // Другие финансовые организации

    GOVERNMENT_NONFINALCIAL("6"), // Государственные нефинансовые организации
    NONGOVERNMENT_NONFINALCIAL("7"), // Негосударственные нефинансовые
				     // организации
    NONPROFIT_FOR_HOUSEHOLDS("8"), // Некоммерческие организации,
				   // обслуживающие домашние хозяйства
    HOUSEHOLDS("9"), // Домашние хозяйства
    INTERNATIONAL_COMPANIES("А"); // Международные организации

    private final String code;

    KZEconomicSector(String code) {
	this.code = code;
    }

    public static KZEconomicSector forCode(String code) {
	for (KZEconomicSector ent : values())
	    if (ent.getCode().equals(code))
		return ent;
	return null;
    }

    // GENERATED

    public String getCode() {
	return code;
    }

}
