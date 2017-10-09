package test.localization.country;

import com.lapsa.kz.country.KZTypeOfSettlement;

import test.localization.ElementsLocalizationTest;

public class KZTypeOfSettlementEnglishTest extends ElementsLocalizationTest<KZTypeOfSettlement> {

    public KZTypeOfSettlementEnglishTest() {
	super(KZTypeOfSettlement.values(), KZTypeOfSettlement.class, LOCALE_ENGLISH);
    }
}
