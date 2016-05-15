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
	private Double price;	
	private Double subtotal;
	private Product product;
	
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getSubTotal() {
		return subtotal;
	}

	public void setSubTotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	@ManyToOne
	@JoinColumn(name="sales_id")
	public Sales getSales() {
		return sales;
	}

	public void setSales(Sales sales) {
		this.sales = sales;
	}

	@ManyToOne
	@JoinColumn(name="product_id")
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
}
