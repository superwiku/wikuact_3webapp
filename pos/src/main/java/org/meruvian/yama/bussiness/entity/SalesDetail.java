package org.meruvian.yama.bussiness.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.meruvian.yama.core.DefaultPersistence;

@Entity
@Table(name="sales_detail")
public class SalesDetail extends DefaultPersistence{
	
	
	private Sales sales;	
	private Integer quantity;	
	private BigDecimal price;	
	private BigDecimal subtotal;
	
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getSubTotal() {
		return subtotal;
	}

	public void setSubTotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name="sales_id")
	public Sales getSales() {
		return sales;
	}

	public void setSales(Sales sales) {
		this.sales = sales;
	}

}
