package com.bernal.inditex.prices.worker.ingestion.reader;

import static java.lang.Integer.parseInt;

import com.bernal.inditex.prices.worker.domain.Price;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Setter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
@Setter
public class PriceCsvReader implements CsvReader<Price> {

	private String filePath;

	public PriceCsvReader(ApplicationArguments args) {
		filePath = args.getNonOptionArgs().get(0);
	}

	@Override
	public List<Price> read() {
		try {
			return read(filePath).stream().map(
				line -> new Price(parseInt(line[0]), parseDate(line[1]), parseDate(line[2]), parseInt(line[3]),
					parseInt(line[4]), parseInt(line[5]), Double.valueOf(line[6]), line[7], parseDate(line[8])))
				.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	private Long parseDate(String dateString) {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd-HH.mm.ss");
		return DateTime.parse(dateString, fmt).getMillis();
	}


}
