package test.localization.economic;

import com.lapsa.kz.economic.KZEconomicSector;

import test.localization.ElementsLocalizationTest;

public class KZEconomicSectorRussianTest extends ElementsLocalizationTest<KZEconomicSector> {

    public KZEconomicSectorRussianTest() {
	super(KZEconomicSector.values(), KZEconomicSector.class, LOCALE_RUSSIAN);
    }
}
