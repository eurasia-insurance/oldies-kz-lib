package test.localization.economic;

import com.lapsa.kz.economic.KZEconomicSector;

import test.localization.ElementsLocalizationTest;

public class KZEconomicSectorKazakhTest extends ElementsLocalizationTest<KZEconomicSector> {

    public KZEconomicSectorKazakhTest() {
	super(KZEconomicSector.values(), KZEconomicSector.class, LOCALE_KAZAKH);
    }
}
