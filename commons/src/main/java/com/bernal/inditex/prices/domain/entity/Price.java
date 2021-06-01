package com.bernal.inditex.prices.domain.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Builder
@Table(name = "PRICES")
public class Price {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "BRAND_ID")
	private Integer brandId;
	@Column(name = "START_DATE")
	private Date starDate;
	@Column(name = "END_DATE")
	private Date endDate;
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
	private Date lastUpdate;

	public Price() {
	}
}
