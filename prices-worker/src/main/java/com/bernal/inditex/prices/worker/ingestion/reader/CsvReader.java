package com.bernal.inditex.prices.worker.ingestion.reader;

import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import lombok.val;

public interface CsvReader<T> {
	List<T> read();

	default List<String[]> read(String filePath) throws IOException, CsvException {
		val file = new File(filePath);
		try(InputStream in = new FileInputStream(file); InputStreamReader reader = new InputStreamReader(in)) {
			com.opencsv.CSVReader csvReader = new CSVReaderBuilder(reader)
				.withSkipLines(1)
				.build();
			return csvReader.readAll();
		}
	}
}
