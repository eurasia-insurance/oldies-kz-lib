package tech.lapsa.kz.vehicle;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.lapsa.kz.country.KZArea;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum RegNumberType implements LocalizedElement {

    // 237 BLM 01
    TYPE_1A(
	    Optional.of(EntityType.INDIVIDUAL),
	    Optional.of(VehicleType.CAR),
	    Arrays.asList(
		    Pattern.compile("\\d\\d\\d\\w\\w\\w(\\d\\d)") //
	    )),

    // 237 01 BLM
    TYPE_2A(
	    Optional.of(EntityType.INDIVIDUAL),
	    Optional.of(VehicleType.CAR),
	    Arrays.asList(
		    Pattern.compile("\\d\\d\\d(\\d\\d)\\w\\w\\w") //
	    )),

    // 237 BL 01
    TYPE_1(
	    Optional.of(EntityType.LEGAL_ENTITY),
	    Optional.of(VehicleType.CAR),
	    Arrays.asList(
		    Pattern.compile("\\d\\d\\d\\w\\w(\\d\\d)") //
	    )),

    // 237 01 BLM
    TYPE_2(
	    Optional.of(EntityType.LEGAL_ENTITY),
	    Optional.of(VehicleType.CAR),
	    Arrays.asList(
		    Pattern.compile("\\d\\d\\d(\\d\\d)\\w\\w") //
	    )),

    // 24 01 KB или 24 KB 01
    TYPE_3(
	    Optional.empty(),
	    Optional.of(VehicleType.MOTORBIKE),
	    Arrays.asList(
		    Pattern.compile("\\d\\d(\\d\\d)\\w\\w"), //
		    Pattern.compile("\\d\\d\\w\\w(\\d\\d)") //
	    )),

    // ANM 01 24 или ANM 24 01
    TYPE_5(
	    Optional.empty(),
	    Optional.of(VehicleType.TRAILER),
	    Arrays.asList(
		    Pattern.compile("\\w\\w\\w(\\d\\d)\\d\\d"), //
		    Pattern.compile("\\w\\w\\w\\d\\d(\\d\\d)") //
	    )),

    // R 575 KMM
    OLD_TYPE_1(
	    Optional.of(EntityType.INDIVIDUAL),
	    Optional.empty(),
	    Arrays.asList(
		    Pattern.compile("(\\w)\\d\\d\\d\\w\\w\\w") //
	    )),

    // A 912 NZ
    OLD_TYPE_2(
	    Optional.of(EntityType.LEGAL_ENTITY),
	    Optional.empty(),
	    Arrays.asList(
		    Pattern.compile("(\\w)\\d\\d\\d\\w\\w") //
	    ))

    ;

    private final Optional<EntityType> entityType;
    private final Optional<VehicleType> vehicleType;
    private final List<Pattern> patterns;

    private RegNumberType(Optional<EntityType> entityType, Optional<VehicleType> vehicleType,
	    List<Pattern> patterns) {
	this.entityType = entityType;
	this.vehicleType = vehicleType;
	this.patterns = patterns;
    }

    Optional<VehicleRegNumber> parseType(String regNumber) {
	return patterns.stream() //
		.map(pattern -> pattern.matcher(regNumber))
		.filter(Matcher::matches)
		.map(matcher -> matcher.group(1))
		.map(KZArea::optionalForAutoCode)
		.filter(Optional::isPresent) // area must defined
		.map(area -> new VehicleRegNumber(this, entityType, regNumber, area, vehicleType))
		.findFirst();
    }
}
