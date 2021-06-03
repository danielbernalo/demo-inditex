package com.bernal.inditex.prices.api.rest.com.bernal.inditex.prices.api.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceDTO {

	private Long productID;
	private Long brandID;
	private Integer priceList;
	private String startDate;
	private String endDate;
	private Double price;
}
