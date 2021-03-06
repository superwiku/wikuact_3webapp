package org.meruvian.yama.bussiness.entity;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.meruvian.yama.core.DefaultPersistence;

@Entity
@Table(name = "purchase_detail")
public class PurchaseDetail extends DefaultPersistence {

	private Integer quantity;
	private Double price;
	private Double subtotal;
	private Purchase purchase;
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

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	@ManyToOne
	@JoinColumn(name="purchase_id")
	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
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
