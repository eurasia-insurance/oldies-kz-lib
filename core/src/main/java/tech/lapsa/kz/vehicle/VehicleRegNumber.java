package tech.lapsa.kz.vehicle;

import static tech.lapsa.kz.DisplayNameElements.*;

import java.io.Serializable;
import java.util.Locale;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Stream;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.lapsa.kz.country.KZArea;

import tech.lapsa.java.commons.function.MyExceptions;
import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.java.commons.localization.Localized;
import tech.lapsa.kz.vehicle.converter.jaxb.XmlVehicleRegNumberAdapter;

@XmlJavaTypeAdapter(XmlVehicleRegNumberAdapter.class)
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
	} catch (IllegalArgumentException e) {
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

    public static boolean valid(VehicleRegNumber value) {
	return value.valid;
    }

    public static boolean nonValid(VehicleRegNumber value) {
	return !valid(value);
    }

    public static <X extends Throwable> VehicleRegNumber requireValid(final Function<String, X> creator,
	    final VehicleRegNumber value) throws X {
	if (valid(value))
	    return value;
	throw MyExceptions.par(creator, "Invalid taxpayer number", "value", value.toString());
    }

    public static VehicleRegNumber requireValid(final VehicleRegNumber value) throws IllegalArgumentException {
	return requireValid(IllegalArgumentException::new, value);
    }

    //

    public static boolean valid(String value) {
	return VehicleRegNumber.assertValid(value).valid;
    }

    public static boolean nonValid(String value) {
	return !valid(value);
    }

    public static <X extends Throwable> String requireValid(final Function<String, X> creator,
	    final String value) throws X {
	if (valid(value))
	    return value;
	throw MyExceptions.par(creator, "Invalid taxpayer number", "value", value.toString());
    }

    public static String requireValid(final String value) throws IllegalArgumentException {
	return requireValid(IllegalArgumentException::new, value);
    }

    //

    VehicleRegNumber(String number, RegNumberType regNumberType, EntityType entityType, KZArea area,
	    VehicleType vehicleType, boolean valid) {
	this.number = MyStrings.requireNonEmpty(number, "number");
	this.regNumberType = MyObjects.requireNonNull(regNumberType, "regNumberType");
	this.entityType = entityType;
	this.vehicleType = vehicleType;
	this.area = area;
	this.valid = valid;
    }

    // for invalid types only
    private VehicleRegNumber(String number) {
	this.number = MyObjects.requireNonNull(number, "number");
	this.regNumberType = null;
	this.entityType = null;
	this.vehicleType = null;
	this.area = null;
	this.valid = false;
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
