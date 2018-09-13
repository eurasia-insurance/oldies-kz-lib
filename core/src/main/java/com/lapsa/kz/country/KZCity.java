package com.lapsa.kz.country;

import static com.lapsa.kz.country.KZArea.*;
import static com.lapsa.kz.country.KZCityType.*;
import static com.lapsa.kz.country.KZTypeOfSettlement.*;

import java.util.Locale;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.localization.LocalizedElement;

public enum KZCity implements LocalizedElement {
    ABAI(CITY, DISTINCT_CENTER, OKGD), // Абай
    AKKOL(CITY, DISTINCT_CENTER, OAKM), // Акколь
    AKSAI(CITY, DISTINCT_CENTER, OZK), // Аксай
    AKSU(CITY, REGIONAL_SUBORDINATION, OPVL), // Аксу
    AKTAU(CITY, REGIONAL_CENTER, OMNG), // Актау
    AKTOBE(CITY, REGIONAL_CENTER, OAKT), // Актобе
    ALGA(CITY, DISTINCT_CENTER, OAKT), // Алга
    ALM(CITY, MAJOR, GALM), // Алматы
    ARAL(CITY, DISTINCT_CENTER, OKZL), // Аральск
    ARKAL(CITY, REGIONAL_SUBORDINATION, OKST), // Аркалык
    ARYS(CITY, REGIONAL_SUBORDINATION, OTRK), // Арысь
    AST(CITY, MAJOR, GAST), // Астана
    ATB(CITY, DISTINCT_CENTER, OAKM), // Атбасар
    ATY(CITY, REGIONAL_CENTER, OATY), // Атырау
    AYAG(CITY, DISTINCT_CENTER, OVK), // Аягоз
    BAIKON(CITY, MAJOR, OKZL), // Байконыр
    BALH(CITY, REGIONAL_SUBORDINATION, OKGD), // Балхаш
    BULA(CITY, DISTINCT_CENTER, OSK), // Булаево
    DERZH(CITY, DISTINCT_CENTER, OAKM), // Державинск
    EREIM(CITY, DISTINCT_CENTER, OAKM), // Ерейментау
    ESIK(CITY, DISTINCT_CENTER, OALM), // Есик
    ESIL(CITY, DISTINCT_CENTER, OAKM), // Есиль
    ZHANO(CITY, REGIONAL_SUBORDINATION, OMNG), // Жанаозен
    ZHANAT(CITY, DISTINCT_CENTER, OZHM), // Жанатас
    ZHARK(CITY, DISTINCT_CENTER, OALM), // Жаркент
    ZHZKZ(CITY, REGIONAL_SUBORDINATION, OKGD), // Жезказган
    ZHEM(CITY, DISTINCT_SUBORDINATION, OAKT), // Жем
    ZHETYSAY(CITY, DISTINCT_CENTER, OTRK), // Жетысай
    ZHITIKARA(CITY, DISTINCT_CENTER, OKST), // Житикара
    ZAISAN(CITY, DISTINCT_CENTER, OVK), // Зайсан
    ZYRIAN(CITY, DISTINCT_SUBORDINATION, OVK), // Зыряновск
    KAZAL(CITY, DISTINCT_SUBORDINATION, OKZL), // Казалинск
    KANDYA(CITY, DISTINCT_CENTER, OAKT), // Кандыагаш
    KAPCH(CITY, REGIONAL_SUBORDINATION, OALM), // Капчагай
    KGND(CITY, REGIONAL_CENTER, OKGD), // Караганда
    KARAZH(CITY, REGIONAL_SUBORDINATION, OKGD), // Каражал
    KARAT(CITY, DISTINCT_CENTER, OZHM), // Каратау
    KARKAR(CITY, DISTINCT_CENTER, OKGD), // Каркаралинск
    KASKEL(CITY, DISTINCT_CENTER, OALM), // Каскелен
    KENTAU(CITY, REGIONAL_SUBORDINATION, OTRK), // Кентау
    KOKSH(CITY, REGIONAL_CENTER, OAKM), // Кокшетау
    KOSTN(CITY, REGIONAL_CENTER, OKST), // Костанай
    KYLSAR(CITY, DISTINCT_CENTER, OATY), // Кульсары
    KURCH(CITY, REGIONAL_SUBORDINATION, OVK), // Курчатов
    KYZYL(CITY, REGIONAL_CENTER, OKZL), // Кызылорда
    LENGER(CITY, DISTINCT_CENTER, OTRK), // Ленгер
    LISAK(CITY, REGIONAL_SUBORDINATION, OKST), // Лисаковск
    MAKIN(CITY, DISTINCT_CENTER, OAKM), // Макинск
    MAMLY(CITY, DISTINCT_CENTER, OSK), // Мамлютка
    PAVL(CITY, REGIONAL_CENTER, OPVL), // Павлодар
    PETRP(CITY, REGIONAL_CENTER, OSK), // Петропавловск
    PRIOZ(CITY, REGIONAL_SUBORDINATION, OKGD), // Приозёрск
    RIDDR(CITY, REGIONAL_SUBORDINATION, OVK), // Риддер
    RUDNI(CITY, REGIONAL_SUBORDINATION, OKST), // Рудный
    SARAN(CITY, REGIONAL_SUBORDINATION, OKGD), // Сарань
    SARKND(CITY, DISTINCT_CENTER, OALM), // Сарканд
    SARYAG(CITY, DISTINCT_CENTER, OTRK), // Сарыагаш
    SATP(CITY, REGIONAL_SUBORDINATION, OKGD), // Сатпаев
    SEMEI(CITY, REGIONAL_SUBORDINATION, OVK), // Семей
    SERGEE(CITY, DISTINCT_CENTER, OSK), // Сергеевка
    SEREBR(CITY, REGIONAL_SUBORDINATION, OVK), // Серебрянск
    STEPNOG(CITY, REGIONAL_SUBORDINATION, OAKM), // Степногорск
    STEPNY(CITY, DISTINCT_CENTER, OAKM), // Степняк
    TAIYN(CITY, DISTINCT_CENTER, OSK), // Тайынша
    TALGAR(CITY, DISTINCT_CENTER, OALM), // Талгар
    TALDYK(CITY, REGIONAL_CENTER, OALM), // Талдыкорган
    TARAZ(CITY, REGIONAL_CENTER, OZHM), // Тараз
    TEKEL(CITY, REGIONAL_SUBORDINATION, OALM), // Текели
    TEMIR(CITY, DISTINCT_SUBORDINATION, OAKT), // Темир
    TEMRT(CITY, REGIONAL_SUBORDINATION, OKGD), // Темиртау
    TURK(CITY, REGIONAL_CENTER, OTRK), // Туркестан
    URALS(CITY, REGIONAL_CENTER, OZK), // Уральск
    UKAM(CITY, REGIONAL_CENTER, OVK), // Усть-Каменогорск
    USHAR(CITY, DISTINCT_CENTER, OALM), // Ушарал
    USHTB(CITY, DISTINCT_CENTER, OALM), // Уштобе
    FRSH(CITY, REGIONAL_SUBORDINATION, OMNG), // Форт-Шевченко
    HROM(CITY, DISTINCT_CENTER, OAKT), // Хромтау
    SHARD(CITY, DISTINCT_CENTER, OTRK), // Шардара
    SHALK(CITY, DISTINCT_CENTER, OAKT), // Шалкар
    SHAR(CITY, REGIONAL_SUBORDINATION, OVK), // Шар
    SHKH(CITY, REGIONAL_SUBORDINATION, OKGD), // Шахтинск
    SHMN(CITY, DISTINCT_CENTER, OVK), // Шемонаиха
    SHU(CITY, DISTINCT_CENTER, OZHM), // Шу
    SHYM(CITY, MAJOR, GSHM), // Шымкент
    SCHU(CITY, DISTINCT_CENTER, OAKM), // Щучинск
    EKIB(CITY, REGIONAL_SUBORDINATION, OPVL), // Экибастуз
    EMBA(CITY, DISTINCT_SUBORDINATION, OAKT), // Эмба
    OTHER, //
    //
    UNDEFINED(false),
    ;

    //

    private final boolean selectable;
    private final KZTypeOfSettlement typeOfSettlement;
    private final KZCityType type;
    private final KZArea area;

    //

    private KZCity() {
	typeOfSettlement = KZTypeOfSettlement.UNDEFINED;
	type = KZCityType.UNDEFINED;
	area = KZArea.UNDEFINED;
	selectable = true;
    }

    private KZCity(final KZTypeOfSettlement typeOfSettlement, final KZCityType type, final KZArea area) {
	this.typeOfSettlement = MyObjects.requireNonNull(typeOfSettlement);
	this.type = MyObjects.requireNonNull(type);
	this.area = MyObjects.requireNonNull(area);
	selectable = true;
    }

    private KZCity(final boolean selectable) {
	typeOfSettlement = KZTypeOfSettlement.UNDEFINED;
	type = KZCityType.UNDEFINED;
	area = KZArea.UNDEFINED;
	this.selectable = selectable;
    }

    //

    public boolean hasArea() {
	return area != KZArea.UNDEFINED;
    }

    public boolean hasType() {
	return type != KZCityType.UNDEFINED;
    }

    public boolean isRegional() {
	return type.isRegional();
    }

    //

    public static final Stream<KZCity> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<KZCity> SELECTABLE_FILTER = KZCity::isSelectable;

    public static final KZCity[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(KZCity[]::new);
    }

    //

    private static final Predicate<KZCity> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final KZCity[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(KZCity[]::new);
    }

    //

    public static final KZCity[] regionalValuesByArea(final KZArea area) {
	MyObjects.requireNonNull(area, "area");
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.filter(KZCity::isRegional) //
		.filter(KZCity::hasArea) //
		.filter(x -> x.getArea() == area) //
		.toArray(KZCity[]::new);
    }

    public static final KZCity[] regionalValuesByArea(final Optional<KZArea> area) {
	MyObjects.requireNonNull(area, "area");
	Stream<KZCity> stream = valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.filter(KZCity::isRegional);
	if (area.isPresent())
	    stream = stream.filter(KZCity::hasArea) //
		    .filter(x -> x.getArea() == area.get());
	return stream.toArray(KZCity[]::new);
    }

    public static final KZCity[] selectableValuesByArea(final KZArea area) {
	MyObjects.requireNonNull(area, "area");
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.filter(KZCity::hasArea) //
		.filter(x -> x.getArea() == area) //
		.toArray(KZCity[]::new);
    }

    public static final KZCity[] selectableValuesByArea(final Optional<KZArea> area) {
	MyObjects.requireNonNull(area, "area");
	Stream<KZCity> stream = valuesStream() //
		.filter(SELECTABLE_FILTER);
	if (area.isPresent())
	    stream = stream.filter(KZCity::hasArea) //
		    .filter(x -> x.getArea() == area.get());
	return stream.toArray(KZCity[]::new);
    }

    //

    @Override
    public String localized(final LocalizationVariant variant, final Locale locale) {
	MyObjects.requireNonNull(variant, "Display variant must be provided");
	MyObjects.requireNonNull(locale, "Locale must be provided");
	final String type = variant == LocalizationVariant.SHORT //
		? null //
		: typeOfSettlement.localized(variant, locale);
	final String city = LocalizedElement.super.localized(variant, locale);
	return generateDisplayName(type, city, locale);
    }

    //

    private static String generateDisplayName(final String typeOfSettlement, final String city,
	    final Locale locale) {
	final StringBuffer sb = new StringBuffer();
	switch (locale.getLanguage()) {
	case "en":
	    sb.append(city);
	    break;
	case "kk":
	    sb.append(city);
	    if (typeOfSettlement != null) {
		sb.append(" ");
		sb.append(typeOfSettlement);
	    }
	    break;
	case "ru":
	default:
	    if (typeOfSettlement != null) {
		sb.append(typeOfSettlement);
		sb.append(" ");
	    }
	    sb.append(city);
	    break;
	}
	return sb.toString().trim();
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }

    public KZTypeOfSettlement getTypeOfSettlement() {
	return typeOfSettlement;
    }

    public KZCityType getType() {
	return type;
    }

    public KZArea getArea() {
	return area;
    }

    public boolean in(KZCity... cities) {
	for (KZCity a : cities)
	    if (a.equals(this))
		return true;
	return false;
    }
}
