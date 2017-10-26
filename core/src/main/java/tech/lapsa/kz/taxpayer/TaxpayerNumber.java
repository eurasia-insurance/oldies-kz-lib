package tech.lapsa.kz.taxpayer;

import static tech.lapsa.kz.DisplayNameElements.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.regex.Pattern;

import tech.lapsa.java.commons.function.MyExceptions;
import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.java.commons.localization.Localized;
import tech.lapsa.java.commons.localization.Localizeds;

public final class TaxpayerNumber implements Localized {

    public static boolean valid(final String value) {
	return of(value).valid;
    }

    public static boolean nonValid(final String value) {
	return !valid(value);
    }

    public static String requireValid(final String value) {
	return requireValid(value, null);
    }

    public static String requireValid(final String value, final String par) {
	if (valid(value))
	    return value;
	throw MyExceptions.illegalArgumentException("Invalid taxpayer number", par, value);
    }

    public static TaxpayerNumber of(final String value) {
	return parse(value)
		.orElseGet(() -> new TaxpayerNumber(value, Optional.empty(), Optional.empty(), false));
    }

    public static Optional<TaxpayerNumber> parse(final String value) {
	MyStrings.requireNonEmpty(value, "value");
	if (IdNumbers.nonValid(value))
	    return Optional.empty();
	Optional<LocalDate> dob = IdNumbers.dateOfBirthFrom(value);
	Optional<Gender> gender = IdNumbers.genderFrom(value);
	return Optional.of(new TaxpayerNumber(value, dob, gender, true));
    }

    private TaxpayerNumber(final String number, final Optional<LocalDate> optionalDateOfBirth,
	    final Optional<Gender> optionalGender,
	    final boolean valid) {
	this.number = MyStrings.requireNonEmpty(number, "number");
	this.optionalDateOfBirth = MyObjects.requireNonNull(optionalDateOfBirth, "optionalDateOfBirth");
	this.optionalGender = MyObjects.requireNonNull(optionalGender, "optionalGender");
	this.valid = valid;
    }

    private final Optional<LocalDate> optionalDateOfBirth;
    private final Optional<Gender> optionalGender;
    private final String number;
    private final boolean valid;

    public String getNumber() {
	return number;
    }

    @Override
    public String toString() {
	return regular();
    }

    public Optional<LocalDate> optionalDateOfBirth() {
	return optionalDateOfBirth;
    }

    public Optional<Gender> optionalGender() {
	return optionalGender;
    }

    public boolean isValid() {
	return valid;
    }

    @Override
    public String localized(LocalizationVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(number);

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	optionalDateOfBirth.map(Localizeds.localDateMapper(locale)) //
		.map(TAXPAYER_NUMBER_DATE_OF_BIRTH.fieldAsCaptionMapper(variant, locale))
		.ifPresent(sj::add);

	optionalGender.map(Localized.toLocalizedMapper(variant, locale)) //
		.map(TAXPAYER_NUMBER_GENDER.fieldAsCaptionMapper(variant, locale))
		.ifPresent(sj::add);

	return sb.append(sj.toString()) //
		.toString();
    }

    private static final class IdNumbers {

	private IdNumbers() {
	}

	static Optional<LocalDate> dateOfBirthFrom(String idNumber) {
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
	    } catch (NumberFormatException e) {
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
	    } catch (DateTimeException e) {
		return Optional.empty();
	    }
	}

	static Optional<Gender> genderFrom(String idNumber) {
	    if (nonValid(idNumber))
		return Optional.empty();

	    int code;

	    try {
		code = Integer.parseInt(idNumber.substring(6, 7));
	    } catch (NumberFormatException e) {
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

	static boolean valid(final String idNumber, final boolean checkDigit) {
	    if (MyStrings.empty(idNumber))
		return false;
	    if (!PATTERN.matcher(idNumber).matches())
		return false;
	    if (!checkDigit)
		return true;
	    return checkDigit(idNumber);
	}

	static boolean nonValid(final String idNumber) {
	    return !valid(idNumber, true);
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
	    byte[] iin = new byte[12];
	    int checksum = 0;
	    for (int i = 0; i < 12; i++) {
		iin[i] = Byte.parseByte(Character.toString(value.charAt(i)));
		checksum += iin[i];
	    }
	    if (checksum == 0) // check for 000 000 000 000
		return false;
	    for (byte[] w : weights) {
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

}
