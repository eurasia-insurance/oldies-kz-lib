package test.localization.vehicle;

import java.util.Locale;

import tech.lapsa.kz.vehicle.EntityType;
import test.localization.ElementsLocalizationTest;

public class EntityTypeTest extends ElementsLocalizationTest<EntityType> {

    public EntityTypeTest() {
	super(EntityType.values(), EntityType.class, Locale.getDefault());
    }

}
