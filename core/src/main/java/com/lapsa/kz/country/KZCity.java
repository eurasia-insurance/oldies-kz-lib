package com.lapsa.kz.country;

public enum KZCity {
    ABAI(KZCityType.DISTINCT_CENTER, KZArea.OKGD), // Абай
    AKKOL(KZCityType.DISTINCT_CENTER, KZArea.OAKM), // Акколь
    AKSAI(KZCityType.DISTINCT_CENTER, KZArea.OZK), // Аксай
    AKSU(KZCityType.REGIONAL_SUBORDINATION, KZArea.OPVL), // Аксу
    AKTAU(KZCityType.REGIONAL_CENTER, KZArea.OMNG), // Актау
    AKTOBE(KZCityType.REGIONAL_CENTER, KZArea.OAKT), // Актобе
    ALGA(KZCityType.DISTINCT_CENTER, KZArea.OAKT), // Алга
    ALM(KZCityType.MAJOR, KZArea.GALM), // Алматы
    ARAL(KZCityType.DISTINCT_CENTER, KZArea.OKZL), // Аральск
    ARKAL(KZCityType.REGIONAL_SUBORDINATION, KZArea.OKST), // Аркалык
    ARYS(KZCityType.REGIONAL_SUBORDINATION, KZArea.OUK), // Арысь
    AST(KZCityType.MAJOR, KZArea.GAST), // Астана
    ATB(KZCityType.DISTINCT_CENTER, KZArea.OAKM), // Атбасар
    ATY(KZCityType.REGIONAL_CENTER, KZArea.OATY), // Атырау
    AYAG(KZCityType.DISTINCT_CENTER, KZArea.OVK), // Аягоз
    BAIKON(KZCityType.MAJOR, KZArea.OKZL), // Байконыр
    BALH(KZCityType.REGIONAL_SUBORDINATION, KZArea.OKGD), // Балхаш
    BULA(KZCityType.DISTINCT_CENTER, KZArea.OSK), // Булаево
    DERZH(KZCityType.DISTINCT_CENTER, KZArea.OAKM), // Державинск
    EREIM(KZCityType.DISTINCT_CENTER, KZArea.OAKM), // Ерейментау
    ESIK(KZCityType.DISTINCT_CENTER, KZArea.OALM), // Есик
    ESIL(KZCityType.DISTINCT_CENTER, KZArea.OAKM), // Есиль
    ZHANO(KZCityType.REGIONAL_SUBORDINATION, KZArea.OMNG), // Жанаозен
    ZHANAT(KZCityType.DISTINCT_CENTER, KZArea.OZHM), // Жанатас
    ZHARK(KZCityType.DISTINCT_CENTER, KZArea.OALM), // Жаркент
    ZHZKZ(KZCityType.REGIONAL_SUBORDINATION, KZArea.OKGD), // Жезказган
    ZHEM(KZCityType.DISTINCT_SUBORDINATION, KZArea.OAKT), // Жем
    ZHETYSAY(KZCityType.DISTINCT_CENTER, KZArea.OUK), // Жетысай
    ZHITIKARA(KZCityType.DISTINCT_CENTER, KZArea.OKST), // Житикара
    ZAISAN(KZCityType.DISTINCT_CENTER, KZArea.OVK), // Зайсан
    ZYRIAN(KZCityType.DISTINCT_SUBORDINATION, KZArea.OVK), // Зыряновск
    KAZAL(KZCityType.DISTINCT_SUBORDINATION, KZArea.OKZL), // Казалинск
    KANDYA(KZCityType.DISTINCT_CENTER, KZArea.OAKT), // Кандыагаш
    KAPCH(KZCityType.REGIONAL_SUBORDINATION, KZArea.OALM), // Капчагай
    KGND(KZCityType.REGIONAL_CENTER, KZArea.OKGD), // Караганда
    KARAZH(KZCityType.REGIONAL_SUBORDINATION, KZArea.OKGD), // Каражал
    KARAT(KZCityType.DISTINCT_CENTER, KZArea.OZHM), // Каратау
    KARKAR(KZCityType.DISTINCT_CENTER, KZArea.OKGD), // Каркаралинск
    KASKEL(KZCityType.DISTINCT_CENTER, KZArea.OALM), // Каскелен
    KENTAU(KZCityType.REGIONAL_SUBORDINATION, KZArea.OUK), // Кентау
    KOKSH(KZCityType.REGIONAL_CENTER, KZArea.OAKM), // Кокшетау
    KOSTN(KZCityType.REGIONAL_CENTER, KZArea.OKST), // Костанай
    KYLSAR(KZCityType.DISTINCT_CENTER, KZArea.OATY), // Кульсары
    KURCH(KZCityType.REGIONAL_SUBORDINATION, KZArea.OVK), // Курчатов
    KYZYL(KZCityType.REGIONAL_CENTER, KZArea.OKZL), // Кызылорда
    LENGER(KZCityType.DISTINCT_CENTER, KZArea.OUK), // Ленгер
    LISAK(KZCityType.REGIONAL_SUBORDINATION, KZArea.OKST), // Лисаковск
    MAKIN(KZCityType.DISTINCT_CENTER, KZArea.OAKM), // Макинск
    MAMLY(KZCityType.DISTINCT_CENTER, KZArea.OSK), // Мамлютка
    PAVL(KZCityType.REGIONAL_CENTER, KZArea.OPVL), // Павлодар
    PETRP(KZCityType.REGIONAL_CENTER, KZArea.OSK), // Петропавловск
    PRIOZ(KZCityType.REGIONAL_SUBORDINATION, KZArea.OKGD), // Приозёрск
    RIDDR(KZCityType.REGIONAL_SUBORDINATION, KZArea.OVK), // Риддер
    RUDNI(KZCityType.REGIONAL_SUBORDINATION, KZArea.OKST), // Рудный
    SARAN(KZCityType.REGIONAL_SUBORDINATION, KZArea.OKGD), // Сарань
    SARKND(KZCityType.DISTINCT_CENTER, KZArea.OALM), // Сарканд
    SARYAG(KZCityType.DISTINCT_CENTER, KZArea.OUK), // Сарыагаш
    SATP(KZCityType.REGIONAL_SUBORDINATION, KZArea.OKGD), // Сатпаев
    SEMEI(KZCityType.REGIONAL_SUBORDINATION, KZArea.OVK), // Семей
    SERGEE(KZCityType.DISTINCT_CENTER, KZArea.OSK), // Сергеевка
    SEREBR(KZCityType.REGIONAL_SUBORDINATION, KZArea.OVK), // Серебрянск
    STEPNOG(KZCityType.REGIONAL_SUBORDINATION, KZArea.OAKM), // Степногорск
    STEPNY(KZCityType.DISTINCT_CENTER, KZArea.OAKM), // Степняк
    TAIYN(KZCityType.DISTINCT_CENTER, KZArea.OSK), // Тайынша
    TALGAR(KZCityType.DISTINCT_CENTER, KZArea.OALM), // Талгар
    TALDYK(KZCityType.REGIONAL_CENTER, KZArea.OALM), // Талдыкорган
    TARAZ(KZCityType.REGIONAL_CENTER, KZArea.OZHM), // Тараз
    TEKEL(KZCityType.REGIONAL_SUBORDINATION, KZArea.OALM), // Текели
    TEMIR(KZCityType.DISTINCT_SUBORDINATION, KZArea.OAKT), // Темир
    TEMRT(KZCityType.REGIONAL_SUBORDINATION, KZArea.OKGD), // Темиртау
    TURK(KZCityType.REGIONAL_SUBORDINATION, KZArea.OUK), // Туркестан
    URALS(KZCityType.REGIONAL_CENTER, KZArea.OZK), // Уральск
    UKAM(KZCityType.REGIONAL_CENTER, KZArea.OVK), // Усть-Каменогорск
    USHAR(KZCityType.DISTINCT_CENTER, KZArea.OALM), // Ушарал
    USHTB(KZCityType.DISTINCT_CENTER, KZArea.OALM), // Уштобе
    FRSH(KZCityType.REGIONAL_SUBORDINATION, KZArea.OMNG), // Форт-Шевченко
    HROM(KZCityType.DISTINCT_CENTER, KZArea.OAKT), // Хромтау
    SHARD(KZCityType.DISTINCT_CENTER, KZArea.OUK), // Шардара
    SHALK(KZCityType.DISTINCT_CENTER, KZArea.OAKT), // Шалкар
    SHAR(KZCityType.REGIONAL_SUBORDINATION, KZArea.OVK), // Шар
    SHKH(KZCityType.REGIONAL_SUBORDINATION, KZArea.OKGD), // Шахтинск
    SHMN(KZCityType.DISTINCT_CENTER, KZArea.OVK), // Шемонаиха
    SHU(KZCityType.DISTINCT_CENTER, KZArea.OZHM), // Шу
    SHYM(KZCityType.REGIONAL_CENTER, KZArea.OUK), // Шымкент
    SCHU(KZCityType.DISTINCT_CENTER, KZArea.OAKM), // Щучинск
    EKIB(KZCityType.REGIONAL_SUBORDINATION, KZArea.OPVL), // Экибастуз
    EMBA(KZCityType.DISTINCT_SUBORDINATION, KZArea.OAKT), // Эмба
    OTHER(null, null);

    public static final String BUNDLE_BASENAME = "KZLibLocalization";

    private final KZCityType type;
    private final KZArea area;

    KZCity(KZCityType type, KZArea area) {
	this.type = type;
	this.area = area;
    }

    public KZCityType getType() {
	return type;
    }

    public KZArea getArea() {
	return area;
    }
}
