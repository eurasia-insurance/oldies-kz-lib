package tech.lapsa.kz.vehicle;

import static tech.lapsa.kz.DisplayNameElements.*;

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

public final class VehicleRegNumber implements Localized {

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

    VehicleRegNumber(String number, RegNumberType regNumberType, Optional<EntityType> optionalEntityType,
	    Optional<KZArea> optionalArea,
	    Optional<VehicleType> optionallVehicleType, boolean valid) {
	this.number = MyStrings.requireNonEmpty(number, "number");
	this.regNumberType = MyObjects.requireNonNull(regNumberType, "regNumberType");
	this.optionalEntityType = MyObjects.requireNonNull(optionalEntityType, "optionalEntityType");
	this.optionallVehicleType = MyObjects.requireNonNull(optionallVehicleType, "optionallVehicleType");
	this.optionalArea = MyObjects.requireNonNull(optionalArea, "optionalArea");
	this.valid = valid;
    }

    private VehicleRegNumber(String value, boolean valid) {
	this.number = MyStrings.requireNonEmpty(value, "value");
	this.regNumberType = null;
	this.optionalEntityType = Optional.empty();
	this.optionallVehicleType = Optional.empty();
	this.optionalArea = Optional.empty();
	this.valid = valid;
    }

    private final RegNumberType regNumberType;
    private final Optional<EntityType> optionalEntityType;
    private final Optional<VehicleType> optionallVehicleType;
    private final String number;
    private final Optional<KZArea> optionalArea;
    private final boolean valid;

    public String getNumber() {
	return number;
    }

    public Optional<KZArea> optionalArea() {
	return optionalArea;
    }

    public RegNumberType getType() {
	return regNumberType;
    }

    public Optional<EntityType> optionalEntityType() {
	return optionalEntityType;
    }

    public Optional<VehicleType> optionalVehicleType() {
	return optionallVehicleType;
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

	optionalArea.map(Localized.toLocalizedMapper(variant, locale)) //
		.map(VEHICLE_AREA.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	optionalEntityType.map(Localized.toLocalizedMapper(variant, locale)) //
		.map(VEHICLE_ENTITY_TYPE.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	optionallVehicleType.map(Localized.toLocalizedMapper(variant, locale)) //
		.map(VEHICLE_TYPE.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	MyOptionals.of(regNumberType).map(Localized.toLocalizedMapper(variant, locale)) //
		.map(VEHICLE_REG_NUMBER_TYPE.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	return sb.append(sj.toString()) //
		.toString();
    }
}
