package com.bernal.inditex.domain.converters;

import com.bernal.inditex.domain.errors.ParseDateException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Utils {

	public static Long parseDateToLong(String dateString) throws ParseDateException {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd-HH.mm.ss");
		try {
			return DateTime.parse(dateString, fmt).getMillis();

		} catch (Exception e) {
			throw new ParseDateException();
		}
	}

	public static String parseLongToDate(Long date) throws ParseDateException {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd-HH.mm.ss");
		try {
			return new DateTime(date).toString(fmt);
		} catch (Exception e) {
			throw new ParseDateException();
		}
	}

}
