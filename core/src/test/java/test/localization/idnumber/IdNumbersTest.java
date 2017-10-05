package test.localization.idnumber;

import static org.junit.Assert.*;
import static test.function.MyExceptionsTest.*;

import org.junit.Test;

import com.lapsa.kz.idnumber.IdNumbers;

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
	expectException(() -> IdNumbers.requireValid(VALID));

    }
}
