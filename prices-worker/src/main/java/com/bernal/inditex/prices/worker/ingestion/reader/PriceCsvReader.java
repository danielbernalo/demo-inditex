package com.bernal.inditex.prices.worker.ingestion.reader;

import static java.lang.Integer.parseInt;

import com.bernal.inditex.prices.domain.entity.Price;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
			return read(filePath).stream().map(line -> createPrice(line)).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	private Price createPrice(String[] line) {
		return Price.builder()
			.brandId(parseInt(line[0]))
			.starDate(parseDate(line[1]))
			.endDate(parseDate(line[2]))
			.priceList(parseInt(line[3]))
			.productId(parseInt(line[4]))
			.priority(parseInt(line[5]))
			.price(Double.valueOf(line[6]))
			.currency(line[7])
			.lastUpdate(parseDate(line[8]))
			.build();
	}

	private Date parseDate(String dateString) {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd-HH.mm.ss");
		return DateTime.parse(dateString, fmt).toDate();
	}
}
