package com.lapsa.kz.economic;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.lapsa.kz.KZLocalizedElement;

public enum KZEconomicSector implements KZLocalizedElement {
    GOVERNMENT("1"), // Правительство Республики Казахстан
    ADMINISTRATION("2"), // Региональные и местные органы управления
    CENTRAL_BANK("3"), // Национальный банк РК и Центральные Банки других
		       // стран
    DEPOSITORY("4"), // Другие депозитные организации
    FINANCIAL("5"), // Другие финансовые организации

    GOVERNMENT_NONFINALCIAL("6"), // Государственные нефинансовые организации
    NONGOVERNMENT_NONFINALCIAL("7"), // Негосударственные нефинансовые
				     // организации
    NONPROFIT_FOR_HOUSEHOLDS("8"), // Некоммерческие организации,
				   // обслуживающие домашние хозяйства
    HOUSEHOLDS("9"), // Домашние хозяйства
    INTERNATIONAL_COMPANIES("А"), // Международные организации
    ;

    //

    private final boolean selectable;
    private final String code;

    //

    private KZEconomicSector(String code) {
	this.code = Objects.requireNonNull(code, "Code must be provided");
	this.selectable = true;
    }

    private KZEconomicSector(String code, boolean selectable) {
	this.code = Objects.requireNonNull(code, "Code must be provided");
	this.selectable = selectable;
    }

    //

    public static final Stream<KZEconomicSector> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<KZEconomicSector> SELECTABLE_FILTER = KZEconomicSector::isSelectable;

    public static final KZEconomicSector[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(KZEconomicSector[]::new);
    }

    //

    private static final Predicate<KZEconomicSector> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final KZEconomicSector[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(KZEconomicSector[]::new);
    }

    //

    public static KZEconomicSector forCode(String code) {
	return valuesStream() //
		.filter(x -> x.code.equals(code)) //
		.findAny() //
		.orElse(null);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }

    public String getCode() {
	return code;
    }
}
