package com.bernal.inditex.domain.converters;

import static com.bernal.inditex.domain.converters.Utils.parseDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.bernal.inditex.domain.errors.ParseDateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class utilsTest {

	public static final long DATE_TIME_VALID_EXPECTED_PARSE = 1602300615000L;
	public static final String DATE_TIME_VALID = "2020-10-10-00.30.15";
	public static final String DATE_TIME_INVALID = "2020/12/12/30:33:33";

	@Test
	@DisplayName("given a string date invalid when parse then result a ParseDateException")
	void parseDateInvalid() throws ParseDateException {
		assertThrows(ParseDateException.class, () -> parseDate(DATE_TIME_INVALID));
	}

	@Test
	@DisplayName("given a string date valid when parse then result a datetime in millis (unixstamp)")
	void parseDateValid() throws ParseDateException {
		assertEquals(parseDate(DATE_TIME_VALID), DATE_TIME_VALID_EXPECTED_PARSE);
	}
}
