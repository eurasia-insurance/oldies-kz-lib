package test.localization.country;

import com.lapsa.kz.country.KZTypeOfSettlement;

import test.localization.ElementsLocalizationTest;

public class KZTypeOfSettlementRussianTest extends ElementsLocalizationTest<KZTypeOfSettlement> {

    public KZTypeOfSettlementRussianTest() {
	super(KZTypeOfSettlement.values(), KZTypeOfSettlement.class, LOCALE_RUSSIAN);
    }
}
