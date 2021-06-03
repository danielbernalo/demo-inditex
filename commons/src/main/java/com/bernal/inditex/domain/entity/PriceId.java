package com.bernal.inditex.domain.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PriceId implements Serializable {

	private Long brandId;
	private Long productId;
	private String currency;
	private Long starDate;
	private Long endDate;

	public PriceId() {
	}
}
