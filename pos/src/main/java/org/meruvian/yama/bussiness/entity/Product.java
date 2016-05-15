package org.meruvian.yama.bussiness.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.meruvian.yama.core.DefaultPersistence;

@Entity
@Table(name = "product")
public class Product extends DefaultPersistence {

	private String barcode;
	private String name;
	private Double price;

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
