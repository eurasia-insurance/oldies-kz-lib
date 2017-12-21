package tech.lapsa.kz.taxpayer;

import static tech.lapsa.kz.DisplayNameElements.*;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.regex.Pattern;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import tech.lapsa.java.commons.function.MyExceptions;
import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.java.commons.localization.Localized;
import tech.lapsa.java.commons.localization.Localizeds;
import tech.lapsa.kz.taxpayer.converter.jaxb.XmlTaxpayerNumberAdapter;

@XmlJavaTypeAdapter(XmlTaxpayerNumberAdapter.class)
public final class TaxpayerNumber implements Localized, Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @param value
     *            must not be null
     * @return new taxpayer number valid or not
     * @throws IllegalArgumentException
     *             if taxpayer number is null
     */
    public static TaxpayerNumber assertValid(final String value) throws IllegalArgumentException {
	try {
	    return of(value);
	} catch (final IllegalArgumentException e) {
	    return new TaxpayerNumber(value, null, null, false);
	}
    }

    /**
     * @param value
     * @return valid taxpayer number
     * @throws IllegalArgumentException
     *             if taxpayer number can'not be parsed or argument empty or
     *             null
     */
    public static TaxpayerNumber of(final String value) throws IllegalArgumentException {
	MyStrings.requireNonEmpty(value, "value");
	IdNumbers.requireValid(value, "value");
	final LocalDate dob = IdNumbers.dateOfBirthFrom(value).orElse(null);
	final Gender gender = IdNumbers.genderFrom(value).orElse(null);
	return new TaxpayerNumber(value, dob, gender, true);
    }

    public static boolean valid(final String value) {
	return TaxpayerNumber.assertValid(value).valid;
    }

    public static boolean nonValid(final String value) {
	return !valid(value);
    }

    public static boolean valid(final TaxpayerNumber value) {
	return value.valid;
    }

    public static boolean nonValid(final TaxpayerNumber value) {
	return !valid(value);
    }

    public static TaxpayerNumber requireValid(final TaxpayerNumber value) throws IllegalArgumentException {
	if (valid(value))
	    return value;
	throw MyExceptions.illegalArgumentPar("Invalid taxpayer number", "value", value.toString());
    }

    public static <X extends Throwable> TaxpayerNumber requireValid(final Function<String, X> creator,
	    final TaxpayerNumber value) throws X {
	if (valid(value))
	    return value;
	throw MyExceptions.par(creator, "Invalid taxpayer number", "value", value.toString());
    }

    public static String requireValid(final String value) throws IllegalArgumentException {
	if (valid(value))
	    return value;
	throw MyExceptions.illegalArgumentPar("Invalid taxpayer number", "value", value);
    }

    //

    private TaxpayerNumber(final String number, final LocalDate dateOfBirth, final Gender gender, final boolean valid) {
	this.number = MyObjects.requireNonNull(number, "number");
	this.dateOfBirth = dateOfBirth;
	this.gender = gender;
	this.valid = valid;
    }

    private final LocalDate dateOfBirth;
    private final Gender gender;
    private final String number;
    private final boolean valid;

    @Override
    public boolean equals(final Object obj) {
	return obj instanceof TaxpayerNumber //
		&& ((TaxpayerNumber) obj).number.equals(number);
    }

    @Override
    public int hashCode() {
	return number.hashCode();
    }

    public String getNumber() {
	return number;
    }

    @Override
    public String toString() {
	return regular();
    }

    public Optional<LocalDate> optionalDateOfBirth() {
	return MyOptionals.of(dateOfBirth);
    }

    public Optional<Gender> optionalGender() {
	return MyOptionals.of(gender);
    }

    @Override
    public String localized(final LocalizationVariant variant, final Locale locale) {
	final StringBuilder sb = new StringBuilder();

	sb.append(number);

	final StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	MyOptionals.of(dateOfBirth) //
		.map(Localizeds.localDateMapper(locale)) //
		.map(TAXPAYER_NUMBER_DATE_OF_BIRTH.fieldAsCaptionMapper(variant, locale))
		.ifPresent(sj::add);

	MyOptionals.of(gender) //
		.map(Localized.toLocalizedMapper(variant, locale)) //
		.map(TAXPAYER_NUMBER_GENDER.fieldAsCaptionMapper(variant, locale))
		.ifPresent(sj::add);

	return sb.append(sj.toString()) //
		.toString();
    }

    private static final class IdNumbers {

	private IdNumbers() {
	}

	static Optional<LocalDate> dateOfBirthFrom(final String idNumber) {
	    if (nonValid(idNumber))
		return Optional.empty();

	    int year;
	    int month;
	    int dayOfMonth;
	    int code;
	    try {
		year = Integer.parseInt(idNumber.substring(0, 2));
		month = Integer.parseInt(idNumber.substring(2, 4));
		dayOfMonth = Integer.parseInt(idNumber.substring(4, 6));
		code = Integer.parseInt(idNumber.substring(6, 7));
	    } catch (final NumberFormatException e) {
		return Optional.empty();
	    }

	    int century = 0;
	    switch (code) {
	    case 1:
	    case 2:
		century = 19;
		break;
	    case 3:
	    case 4:
		century = 20;
		break;
	    case 5:
	    case 6:
		century = 21;
		break;
	    }

	    if (century == 0)
		return Optional.empty();

	    year += (century - 1) * 100;

	    try {
		return Optional.of(LocalDate.of(year, month, dayOfMonth));
	    } catch (final DateTimeException e) {
		return Optional.empty();
	    }
	}

	static Optional<Gender> genderFrom(final String idNumber) {
	    if (nonValid(idNumber))
		return Optional.empty();

	    int code;

	    try {
		code = Integer.parseInt(idNumber.substring(6, 7));
	    } catch (final NumberFormatException e) {
		return Optional.empty();
	    }

	    switch (code) {
	    case 1:
	    case 3:
	    case 5:
		return Optional.of(Gender.MALE);
	    case 2:
	    case 4:
	    case 6:
		return Optional.of(Gender.FEMALE);
	    default:
		return Optional.empty();
	    }
	}

	//

	static boolean valid(final String taxpayerNumber, final boolean checkDigit) {
	    if (MyStrings.empty(taxpayerNumber))
		return false;
	    if (!PATTERN.matcher(taxpayerNumber).matches())
		return false;
	    if (!checkDigit)
		return true;
	    return checkDigit(taxpayerNumber);
	}

	static boolean nonValid(final String taxpayerNumber) {
	    return !valid(taxpayerNumber, true);
	}

	static void requireValid(final String taxpayerNumber, final String par) throws IllegalArgumentException {
	    if (nonValid(taxpayerNumber))
		throw MyExceptions.illegalArgumentPar("Invalid taxpayer number", par, taxpayerNumber);
	}

	//

	private static final Pattern PATTERN = Pattern.compile("^[0-9]{12}?$");

	/*
	 * 5. Алгоритм расчета значения контрольного разряда
	 *
	 * В целях осуществления контроля и снижения ошибок клавиатурного ввода
	 * в составе ИИН (БИН) предусматривается наличие контрольного 12-го
	 * разряда, при расчете которого будет использоваться следующий алгоритм
	 * в два цикла:
	 *
	 * а12=(а1*b1+а2*b2+а3*b3+а4*b4+а5*b5+а6*b6+а7*b7+а8*b8+а9*b9+a10*b10+
	 * a11* b11) mod 11,
	 *
	 * где: ai - значение i-гo разряда;
	 *
	 * bi - вес i-гo разряда.
	 *
	 * разряд ИИН: 1 2 3 4 5 6 7 8 9 10 11
	 *
	 * вес разряда: 1 2 3 4 5 6 7 8 9 10 11.
	 *
	 * 1. Если полученное число равно 10, то расчет контрольного разряда
	 * производится с другой последовательностью весов:
	 *
	 * разряд ИИН: 1 2 3 4 5 6 7 8 9 10 11
	 *
	 * вес разряда: 3 4 5 6 7 8 9 10 11 1 2.
	 *
	 * 2. Если полученное число также равно 10, то данный ИИН не
	 * используется.
	 *
	 * 3. Если полученное число имеет значение от 0 до 9, то данное число
	 * берется в качестве контрольного разряда.
	 */
	private static byte[][] weights = new byte[][] { new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 },
		new byte[] { 3, 4, 5, 6, 7, 8, 9, 10, 11, 1, 2 } };

	private static boolean checkDigit(final String value) {
	    final byte[] iin = new byte[12];
	    int checksum = 0;
	    for (int i = 0; i < 12; i++) {
		iin[i] = Byte.parseByte(Character.toString(value.charAt(i)));
		checksum += iin[i];
	    }
	    if (checksum == 0) // check for 000 000 000 000
		return false;
	    for (final byte[] w : weights) {
		int control = 0;
		for (int i = 0; i < 11; i++)
		    control += iin[i] * w[i];
		control = control % 11;
		if (control < 10)
		    return control == iin[11];
	    }
	    return false;
	}

    }

    public LocalDate getDateOfBirth() {
	return dateOfBirth;
    }

    public Gender getGender() {
	return gender;
    }
}
