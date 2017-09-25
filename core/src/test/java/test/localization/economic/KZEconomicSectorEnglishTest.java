package test.localization.economic;

import com.lapsa.kz.economic.KZEconomicSector;

import test.localization.ElementsLocalizationTest;

public class KZEconomicSectorEnglishTest extends ElementsLocalizationTest<KZEconomicSector> {

    public KZEconomicSectorEnglishTest() {
	super(KZEconomicSector.values(), KZEconomicSector.class, LOCALE_ENGLISH);
    }
}
