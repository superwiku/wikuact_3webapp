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
@Table(name="T_SALES_DETAIL")
public class SalesDetail {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID", nullable=false)
	private Product product;
	
	@Column(name="QUANTITY", nullable=false)
	private Integer quantity;
	
	@Column(name="PRICE", nullable=false, precision=18, scale=0)
	private BigDecimal price;
	
	@Column(name="SUBTOTAL", nullable=false, precision=18, scale=0)
	private BigDecimal subtotal;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	public BigDecimal getSubTotal() {
		return subtotal;
	}

	public void setSubTotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	
}
