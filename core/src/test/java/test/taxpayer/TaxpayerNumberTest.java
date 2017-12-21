package test.taxpayer;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static test.assertion.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Test;

import tech.lapsa.kz.taxpayer.Gender;
import tech.lapsa.kz.taxpayer.TaxpayerNumber;

public class TaxpayerNumberTest {

    @Test
    public void testValid() {
	final String VALID = "800225000319";
	final String INVALID = "12312";

	assertTrue(TaxpayerNumber.valid(VALID));
	assertTrue(TaxpayerNumber.nonValid(INVALID));
	unexpectException(() -> TaxpayerNumber.requireValid(VALID));

	assertFalse(TaxpayerNumber.nonValid(VALID));
	assertFalse(TaxpayerNumber.valid(INVALID));
	expectException(() -> TaxpayerNumber.requireValid(INVALID));
    }

    @Test
    public void testGender() {
	final String FEMALE = "811203400953";

	final Optional<Gender> female = TaxpayerNumber.of(FEMALE).optionalGender();
	assertNotNull(female);
	assertTrue(female.isPresent());
	assertThat(female.get(), equalTo(Gender.FEMALE));

	final String MALE = "800705300098";

	final Optional<Gender> male = TaxpayerNumber.of(MALE).optionalGender();
	assertNotNull(male);
	assertTrue(male.isPresent());
	assertThat(male.get(), equalTo(Gender.MALE));

	final String UNRECOGNIZABLE = "800225000319";

	final Optional<Gender> unrec = TaxpayerNumber.of(UNRECOGNIZABLE).optionalGender();
	assertNotNull(unrec);
	assertFalse(unrec.isPresent());
    }

    @Test
    public void testDateOfBirth() {
	final String OK = "811203400953";

	final Optional<LocalDate> ok = TaxpayerNumber.of(OK).optionalDateOfBirth();
	assertNotNull(ok);
	assertTrue(ok.isPresent());
	assertThat(ok.get(), equalTo(LocalDate.of(1981, 12, 03)));

	final String INVALID = "800225000319";

	final Optional<LocalDate> invalid = TaxpayerNumber.of(INVALID).optionalDateOfBirth();
	assertNotNull(invalid);
	assertFalse(invalid.isPresent());
    }
}
