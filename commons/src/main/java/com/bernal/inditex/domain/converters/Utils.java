package com.bernal.inditex.domain.converters;

import com.bernal.inditex.domain.errors.ParseDateException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Utils {

	public static Long parseDate(String dateString) throws ParseDateException {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd-HH.mm.ss");
		try {
		return DateTime.parse(dateString, fmt).getMillis();

		} catch (Exception e) {
			throw new ParseDateException();
		}
	}

}
