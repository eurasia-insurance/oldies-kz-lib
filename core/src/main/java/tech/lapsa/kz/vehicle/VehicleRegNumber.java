package tech.lapsa.kz.vehicle;

import static tech.lapsa.kz.DisplayNameElements.*;

import java.io.Serializable;
import java.util.Locale;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Stream;

import com.lapsa.kz.country.KZArea;

import tech.lapsa.java.commons.function.MyExceptions;
import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.java.commons.localization.Localized;

public final class VehicleRegNumber implements Localized, Serializable {

    private static final long serialVersionUID = 1L;

    public static VehicleRegNumber of(String value) {
	return parse(value)
		.orElseGet(() -> new VehicleRegNumber(value, false));
    }

    public static Optional<VehicleRegNumber> parse(String value) {
	MyStrings.requireNonEmpty(value, "value");
	return Stream.of(RegNumberType.values())
		.map(x -> x.parseType(value)) //
		.filter(Optional::isPresent) //
		.map(Optional::get) //
		.findFirst();
    }

    VehicleRegNumber(String number, RegNumberType regNumberType, EntityType entityType, KZArea area,
	    VehicleType vehicleType, boolean valid) {
	this.number = MyStrings.requireNonEmpty(number, "number");
	this.regNumberType = MyObjects.requireNonNull(regNumberType, "regNumberType");
	this.entityType = entityType;
	this.vehicleType = vehicleType;
	this.area = area;
	this.valid = valid;
    }

    private VehicleRegNumber(String value, boolean valid) {
	this.number = MyStrings.requireNonEmpty(value, "value");
	this.regNumberType = null;
	this.entityType = null;
	this.vehicleType = null;
	this.area = null;
	this.valid = valid;
    }

    private final RegNumberType regNumberType;
    private final EntityType entityType;
    private final VehicleType vehicleType;
    private final String number;
    private final KZArea area;
    private final boolean valid;

    @Override
    public boolean equals(Object obj) {
	return obj instanceof VehicleRegNumber //
		&& ((VehicleRegNumber) obj).number.equals(number);
    }

    @Override
    public int hashCode() {
	return number.hashCode();
    }

    public String getNumber() {
	return number;
    }

    public RegNumberType getRegNumberType() {
	return regNumberType;
    }

    public EntityType getEntityType() {
	return entityType;
    }

    public VehicleType getVehicleType() {
	return vehicleType;
    }

    public KZArea getArea() {
	return area;
    }

    public Optional<KZArea> optionalArea() {
	return MyOptionals.of(area);
    }

    public RegNumberType getType() {
	return regNumberType;
    }

    public Optional<EntityType> optionalEntityType() {
	return MyOptionals.of(entityType);
    }

    public Optional<VehicleType> optionalVehicleType() {
	return MyOptionals.of(vehicleType);
    }

    public boolean isValid() {
	return valid;
    }

    public VehicleRegNumber requireValid() {
	return requireValid(null);
    }

    public VehicleRegNumber requireValid(String par) {
	if (valid)
	    return this;
	throw MyExceptions.illegalArgumentException("Invalid vehicle registartion number", par, this.toString());
    }

    @Override
    public String toString() {
	return regular();
    }

    @Override
    public String localized(LocalizationVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(number);

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	MyOptionals.of(area) //
		.map(Localized.toLocalizedMapper(variant, locale)) //
		.map(VEHICLE_AREA.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	MyOptionals.of(entityType) //
		.map(Localized.toLocalizedMapper(variant, locale)) //
		.map(VEHICLE_ENTITY_TYPE.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	MyOptionals.of(vehicleType) //
		.map(Localized.toLocalizedMapper(variant, locale)) //
		.map(VEHICLE_TYPE.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	MyOptionals.of(regNumberType).map(Localized.toLocalizedMapper(variant, locale)) //
		.map(VEHICLE_REG_NUMBER_TYPE.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	return sb.append(sj.toString()) //
		.toString();
    }
}
