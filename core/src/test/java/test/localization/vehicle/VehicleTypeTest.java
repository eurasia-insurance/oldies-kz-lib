package test.localization.vehicle;

import java.util.Locale;

import tech.lapsa.kz.vehicle.VehicleType;
import test.localization.ElementsLocalizationTest;

public class VehicleTypeTest extends ElementsLocalizationTest<VehicleType> {

    public VehicleTypeTest() {
	super(VehicleType.values(), VehicleType.class, Locale.getDefault());
    }

}
