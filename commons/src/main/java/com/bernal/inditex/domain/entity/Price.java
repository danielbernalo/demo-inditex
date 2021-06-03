package com.bernal.inditex.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Builder
@IdClass(PriceId.class)
@Table(name = "PRICES")
public class Price {

	@Id
	@Column(name = "BRAND_ID")
	private Long brandId;
	@Id
	@Column(name = "START_DATE")
	private Long starDate;
	@Id
	@Column(name = "END_DATE")
	private Long endDate;
	@Column(name = "PRICE_LIST")
	private Integer priceList;
	@Id
	@Column(name = "PRODUCT_ID")
	private Long productId;
	@Column(name = "PRIORITY")
	private Long priority;
	@Column(name = "PRICE")
	private Double price;
	@Id
	@Column(name = "CURR")
	private String currency;
	@Column(name = "LAST_UPDATE")
	private Long lastUpdate;

	public Price() {
	}
}
