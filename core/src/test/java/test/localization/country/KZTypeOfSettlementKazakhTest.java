package test.localization.country;

import com.lapsa.kz.country.KZTypeOfSettlement;

import test.localization.ElementsLocalizationTest;

public class KZTypeOfSettlementKazakhTest extends ElementsLocalizationTest<KZTypeOfSettlement> {

    public KZTypeOfSettlementKazakhTest() {
	super(KZTypeOfSettlement.values(), KZTypeOfSettlement.class, LOCALE_KAZAKH);
    }
}
