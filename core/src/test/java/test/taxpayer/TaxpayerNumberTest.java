package test.taxpayer;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static test.assertion.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Test;

import tech.lapsa.kz.taxpayer.Gender;
import tech.lapsa.kz.taxpayer.TaxpayerNumber;
import tech.lapsa.kz.taxpayer.TaxpayerNumbers;

public class TaxpayerNumberTest {

    @Test
    public void testValid() {
	final String VALID = "800225000319";
	final String INVALID = "12312";

	assertTrue(TaxpayerNumbers.valid(VALID));
	assertTrue(TaxpayerNumbers.nonValid(INVALID));
	unexpectException(() -> TaxpayerNumbers.requireValid(VALID));

	assertFalse(TaxpayerNumbers.nonValid(VALID));
	assertFalse(TaxpayerNumbers.valid(INVALID));
	expectException(() -> TaxpayerNumbers.requireValid(INVALID));
    }

    @Test
    public void testGender() {
	final String FEMALE = "811203400953";

	Optional<Gender> female = TaxpayerNumber.of(FEMALE).optionalGender();
	assertNotNull(female);
	assertTrue(female.isPresent());
	assertThat(female.get(), equalTo(Gender.FEMALE));

	final String MALE = "800705300098";

	Optional<Gender> male = TaxpayerNumber.of(MALE).optionalGender();
	assertNotNull(male);
	assertTrue(male.isPresent());
	assertThat(male.get(), equalTo(Gender.MALE));

	final String UNRECOGNIZABLE = "800225000319";

	Optional<Gender> unrec = TaxpayerNumber.of(UNRECOGNIZABLE).optionalGender();
	assertNotNull(unrec);
	assertFalse(unrec.isPresent());
    }

    @Test
    public void testDateOfBirth() {
	final String OK = "811203400953";

	Optional<LocalDate> ok = TaxpayerNumber.of(OK).optionalDateOfBirth();
	assertNotNull(ok);
	assertTrue(ok.isPresent());
	assertThat(ok.get(), equalTo(LocalDate.of(1981, 12, 03)));

	final String INVALID = "800225000319";

	Optional<LocalDate> invalid = TaxpayerNumber.of(INVALID).optionalDateOfBirth();
	assertNotNull(invalid);
	assertFalse(invalid.isPresent());
    }
}
