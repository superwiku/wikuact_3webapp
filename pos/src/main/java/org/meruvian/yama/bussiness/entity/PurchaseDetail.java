package org.meruvian.yama.bussiness.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_PURCHASE_DETAIL")
public class PurchaseDetail {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@Column(name="QUANTITY")
	private Integer quantity;
	
	@Column(name="PRICE", nullable=false, precision=18, scale=0)
	private BigDecimal price;
	
	@Column(name="PRICE", nullable=false, precision=18, scale=0)
	private BigDecimal subtotal;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID", nullable=false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="PURCHASE_ID", nullable=false)
	private Purchase purchase;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
	
	

}
