package com.bernal.inditex.prices.worker.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Price {

	private Integer brandId;
	private Long starDate;
	private Long endDate;
	private Integer priceList;
	private Integer productId;
	private Integer priority;
	private Double price;
	private String currency;
	private Long lastUpdate;

}
