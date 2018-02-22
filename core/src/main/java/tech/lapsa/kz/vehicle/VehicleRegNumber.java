package tech.lapsa.kz.vehicle;

import static tech.lapsa.kz.DisplayNameElements.*;

import java.io.Serializable;
import java.util.Locale;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Stream;

import com.lapsa.kz.country.KZArea;

import tech.lapsa.java.commons.function.MyExceptions;
import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.java.commons.localization.Localized;

public final class VehicleRegNumber implements Localized, Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @param value
     *            must not be null
     * @return new vehicle reg number valid or not
     * @throws IllegalArgumentException
     *             if vehicle reg number is null
     */
    public static VehicleRegNumber assertValid(final String value) throws IllegalArgumentException {
	try {
	    return of(value);
	} catch (final IllegalArgumentException e) {
	    return new VehicleRegNumber(value);
	}
    }

    /**
     * @param value
     * @return valid vehicle reg number
     * @throws IllegalArgumentException
     *             if vehicle reg number can'not be parsed or argument empty or
     *             null
     */
    public static VehicleRegNumber of(final String value) throws IllegalArgumentException {
	MyStrings.requireNonEmpty(value, "value");
	return Stream.of(RegNumberType.values())
		.map(x -> x.parseType(value)) //
		.filter(Optional::isPresent) //
		.map(Optional::get) //
		.findFirst() //
		.orElseThrow(
			() -> MyExceptions.illegalArgumentPar("Invalid vehicle reg number", "vehicleNumber", value));
    }

    //

    public static boolean valid(final VehicleRegNumber value) {
	return value.valid;
    }

    public static boolean nonValid(final VehicleRegNumber value) {
	return !valid(value);
    }

    public static <X extends Exception> VehicleRegNumber requireValid(final Function<String, X> creator,
	    final VehicleRegNumber value) throws X {
	if (valid(value))
	    return value;
	throw MyExceptions.par(creator, "Invalid taxpayer number", "value", value.toString());
    }

    public static VehicleRegNumber requireValid(final VehicleRegNumber value) throws IllegalArgumentException {
	return requireValid(IllegalArgumentException::new, value);
    }

    //

    public static boolean valid(final String value) {
	return VehicleRegNumber.assertValid(value).valid;
    }

    public static boolean nonValid(final String value) {
	return !valid(value);
    }

    public static <X extends Exception> String requireValid(final Function<String, X> creator,
	    final String value) throws X {
	if (valid(value))
	    return value;
	throw MyExceptions.par(creator, "Invalid taxpayer number", "value", value.toString());
    }

    public static String requireValid(final String value) throws IllegalArgumentException {
	return requireValid(IllegalArgumentException::new, value);
    }

    public static String normalizeNumber(final String number) throws IllegalArgumentException {
	if (MyObjects.isNull(number))
	    return null;
	final char[] cyrs = { 'А', 'В', 'С', 'Е', 'К', 'М', 'О', 'Р', 'Т' };
	final char[] lats = { 'A', 'B', 'C', 'E', 'K', 'M', 'O', 'P', 'T' };
	String num = number.toUpperCase().replaceAll("\\s", "");
	for (int i = 0; i < cyrs.length; i++) {
	    final char from = cyrs[i];
	    final char to = lats[i];
	    num = num.replace(from, to);
	}
	return num;
    }

    //

    VehicleRegNumber(final String number, final RegNumberType regNumberType, final EntityType entityType,
	    final KZArea area,
	    final VehicleType vehicleType, final boolean valid) {
	this.number = MyStrings.requireNonEmpty(number, "number");
	this.regNumberType = MyObjects.requireNonNull(regNumberType, "regNumberType");
	this.entityType = entityType;
	this.vehicleType = vehicleType;
	this.area = area;
	this.valid = valid;
    }

    // for invalid types only
    private VehicleRegNumber(final String number) {
	this.number = MyObjects.requireNonNull(number, "number");
	regNumberType = null;
	entityType = null;
	vehicleType = null;
	area = null;
	valid = false;
    }

    private final RegNumberType regNumberType;
    private final EntityType entityType;
    private final VehicleType vehicleType;
    private final String number;
    private final KZArea area;
    private final boolean valid;

    @Override
    public boolean equals(final Object obj) {
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

    @Override
    public String toString() {
	return regular();
    }

    @Override
    public String localized(final LocalizationVariant variant, final Locale locale) {
	final StringBuilder sb = new StringBuilder();

	sb.append(number);

	final StringJoiner sj = new StringJoiner(", ", " ", "");
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
