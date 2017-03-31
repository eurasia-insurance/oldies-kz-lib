package com.lapsa.kz.idnumber;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class IDNumberUtils {

    public static enum Sex {
	MALE, FEMALE;
    }

    /*
     * This algorythm is described in article below
     * http://adilet.zan.kz/rus/docs/P030000565_
     */
    public static Sex parseSexFromIdNumber(String idNumber) {
	if (idNumber == null || idNumber.isEmpty() || idNumber.length() < 12)
	    return null;

	int code;

	try {
	    code = Integer.parseInt(idNumber.substring(6, 7));
	} catch (NumberFormatException e) {
	    return null;
	}

	switch (code) {
	case 1:
	case 3:
	case 5:
	    return Sex.MALE;
	case 2:
	case 4:
	case 6:
	    return Sex.FEMALE;
	}
	return null;
    }

    public static Date parseDOBFromIdNumberDate(String idNumber) {
	Calendar c = parseDOBFromIdNumberCalendar(idNumber);
	if (c == null)
	    return null;
	return c.getTime();
    }

    public static Calendar parseDOBFromIdNumberCalendar(String idNumber) {
	LocalDate c = parseDOBFromIdNumberLocalDate(idNumber);
	if (c == null)
	    return null;
	Calendar ret = Calendar.getInstance();
	ret.setTime(ret.getTime());
	return ret;
    }

    /*
     * This algorythm is described in article below
     * http://adilet.zan.kz/rus/docs/P030000565_
     */
    public static LocalDate parseDOBFromIdNumberLocalDate(String idNumber) {
	if (idNumber == null || idNumber.isEmpty() || idNumber.length() < 12)
	    return null;

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
	    return null;
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
	    return null;

	year += (century - 1) * 100;

	return LocalDate.of(year, month, dayOfMonth);
    }

}
