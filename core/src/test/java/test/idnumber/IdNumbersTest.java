package test.idnumber;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static test.assertion.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Test;

import com.lapsa.kz.idnumber.IdNumbers;
import com.lapsa.kz.idnumber.IdNumbers.Gender;

public class IdNumbersTest {

    @Test
    public void testValid() {
	final String VALID = "800225000319";
	final String INVALID = "12312";

	assertTrue(IdNumbers.valid(VALID));
	assertTrue(IdNumbers.nonValid(INVALID));
	unexpectException(() -> IdNumbers.requireValid(VALID));

	assertFalse(IdNumbers.nonValid(VALID));
	assertFalse(IdNumbers.valid(INVALID));
	expectException(() -> IdNumbers.requireValid(INVALID));
    }

    @Test
    public void testGender() {
	final String FEMALE = "811203400953";

	Optional<Gender> female = IdNumbers.genderFrom(FEMALE);
	assertNotNull(female);
	assertTrue(female.isPresent());
	assertThat(female.get(), equalTo(Gender.FEMALE));

	final String MALE = "800705300098";

	Optional<Gender> male = IdNumbers.genderFrom(MALE);
	assertNotNull(male);
	assertTrue(male.isPresent());
	assertThat(male.get(), equalTo(Gender.MALE));

	final String UNRECOGNIZABLE = "800225000319";

	Optional<Gender> unrec = IdNumbers.genderFrom(UNRECOGNIZABLE);
	assertNotNull(unrec);
	assertFalse(unrec.isPresent());

	final String INVALID = "12312";

	Optional<Gender> invalid = IdNumbers.genderFrom(INVALID);
	assertNotNull(invalid);
	assertFalse(invalid.isPresent());
    }

    @Test
    public void testDateOfBirth() {
	final String OK = "811203400953";

	Optional<LocalDate> ok = IdNumbers.dateOfBirthFrom(OK);
	assertNotNull(ok);
	assertTrue(ok.isPresent());
	assertThat(ok.get(), equalTo(LocalDate.of(1981, 12, 03)));

	final String INVALID = null;

	Optional<LocalDate> invalid = IdNumbers.dateOfBirthFrom(INVALID);
	assertNotNull(invalid);
	assertFalse(invalid.isPresent());
    }
}
