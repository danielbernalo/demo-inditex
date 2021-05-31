package com.bernal.inditex.prices.commons.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PRICES", schema = "PUBLIC")
public class PriceEntity {

	@Id
	@Column(name = "ID")
	private Integer id;
	@Column(name = "BRAND_ID")
	private Integer brandId;
	@Column(name = "START_DATE")
	private Long starDate;
	@Column(name = "END_DATE")
	private Long endDate;
	@Column(name = "PRICE_LIST")
	private Integer priceList;
	@Column(name = "PRODUCT_ID")
	private Integer productId;
	@Column(name = "PRIORITY")
	private Integer priority;
	@Column(name = "PRICE")
	private Double price;
	@Column(name = "CURR")
	private String currency;
	@Column(name = "LAST_UPDATE")
	private Long lastUpdate;

}
