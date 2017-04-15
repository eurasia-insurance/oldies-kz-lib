package com.lapsa.kz.country;

import static com.lapsa.kz.country.KZTypeOfSettlement.*;
import static com.lapsa.kz.country.KZCityType.*;
import static com.lapsa.kz.country.KZArea.*;

import com.lapsa.kz.KZLocalizationBundleBase;

public enum KZCity implements KZLocalizationBundleBase {
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
    ARYS(CITY, REGIONAL_SUBORDINATION, OUK), // Арысь
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
    ZHETYSAY(CITY, DISTINCT_CENTER, OUK), // Жетысай
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
    KENTAU(CITY, REGIONAL_SUBORDINATION, OUK), // Кентау
    KOKSH(CITY, REGIONAL_CENTER, OAKM), // Кокшетау
    KOSTN(CITY, REGIONAL_CENTER, OKST), // Костанай
    KYLSAR(CITY, DISTINCT_CENTER, OATY), // Кульсары
    KURCH(CITY, REGIONAL_SUBORDINATION, OVK), // Курчатов
    KYZYL(CITY, REGIONAL_CENTER, OKZL), // Кызылорда
    LENGER(CITY, DISTINCT_CENTER, OUK), // Ленгер
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
    SARYAG(CITY, DISTINCT_CENTER, OUK), // Сарыагаш
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
    TURK(CITY, REGIONAL_SUBORDINATION, OUK), // Туркестан
    URALS(CITY, REGIONAL_CENTER, OZK), // Уральск
    UKAM(CITY, REGIONAL_CENTER, OVK), // Усть-Каменогорск
    USHAR(CITY, DISTINCT_CENTER, OALM), // Ушарал
    USHTB(CITY, DISTINCT_CENTER, OALM), // Уштобе
    FRSH(CITY, REGIONAL_SUBORDINATION, OMNG), // Форт-Шевченко
    HROM(CITY, DISTINCT_CENTER, OAKT), // Хромтау
    SHARD(CITY, DISTINCT_CENTER, OUK), // Шардара
    SHALK(CITY, DISTINCT_CENTER, OAKT), // Шалкар
    SHAR(CITY, REGIONAL_SUBORDINATION, OVK), // Шар
    SHKH(CITY, REGIONAL_SUBORDINATION, OKGD), // Шахтинск
    SHMN(CITY, DISTINCT_CENTER, OVK), // Шемонаиха
    SHU(CITY, DISTINCT_CENTER, OZHM), // Шу
    SHYM(CITY, REGIONAL_CENTER, OUK), // Шымкент
    SCHU(CITY, DISTINCT_CENTER, OAKM), // Щучинск
    EKIB(CITY, REGIONAL_SUBORDINATION, OPVL), // Экибастуз
    EMBA(CITY, DISTINCT_SUBORDINATION, OAKT), // Эмба
    OTHER(null, null, null), // TODO найти решение для того, чтобы от этого
			     // значения
    // энумерации можно было бы избавиться. Сейчас это
    // введено для JSF движка
    //
    UNDEFINED(null, null, null),
    //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }

    private final KZTypeOfSettlement typeOfSettlement;
    private final KZCityType type;
    private final KZArea area;

    KZCity(KZTypeOfSettlement typeOfSettlement, KZCityType type, KZArea area) {
	this.typeOfSettlement = typeOfSettlement;
	this.type = type;
	this.area = area;
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
}
