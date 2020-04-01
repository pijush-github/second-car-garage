package com.ing.fullstack.challenge.webapp.secondcargarage.domain;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class Location {
	
	@Field("lat")
	@JsonProperty("lat")
	private BigDecimal lattitude;
	@Field("long")
	@JsonProperty("long")
	private BigDecimal longitude;
	
	public Location(final BigDecimal lattitude, final BigDecimal longitude) {
		this.setLattitude(lattitude);
		this.setLongitude(longitude);
	}

	public BigDecimal getLattitude() {
		return lattitude;
	}

	public void setLattitude(BigDecimal lattitude) {
		this.lattitude = lattitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
}
