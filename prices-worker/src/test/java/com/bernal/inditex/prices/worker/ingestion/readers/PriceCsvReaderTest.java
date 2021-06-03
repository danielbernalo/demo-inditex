package com.bernal.inditex.prices.worker.ingestion.readers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.bernal.inditex.domain.entity.Price;
import com.bernal.inditex.prices.worker.domain.errors.MissingFilePathException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class PriceCsvReaderTest {

	public static final String RESOURCES_NOT_EXISTS_FILE_CSV = "./resources/not_exists_file.csv";
	public static final String RESOURCES_VALID_FILE_CSV = "./src/test/resources/data_import_test.csv";

	@MockBean
	ApplicationArguments args;

	CsvReader<Price> csvReader;

	@Test
	@DisplayName("given a invalid file path, when try read csv import, then return and MissingFilePathException")
	void testInvalidFilePath() {
		when(args.getNonOptionArgs()).thenReturn(List.of(RESOURCES_NOT_EXISTS_FILE_CSV));
		csvReader = new PriceCsvReader(args);
		assertThrows(MissingFilePathException.class, () -> csvReader.read());
	}

	@Test
	@DisplayName("given a valid file path, when try read csv import, then return list of prices")
	void testValidFilePath() throws MissingFilePathException {
		when(args.getNonOptionArgs()).thenReturn(List.of(RESOURCES_VALID_FILE_CSV));
		csvReader = new PriceCsvReader(args);
		List<Price> result = csvReader.read();
		assertNotNull(result);
		assertEquals(result.size(), 1);
	}
}
