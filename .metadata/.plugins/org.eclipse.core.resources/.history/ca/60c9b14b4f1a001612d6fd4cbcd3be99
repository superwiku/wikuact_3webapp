package org.meruvian.yama.bussiness.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.meruvian.yama.core.DefaultPersistence;


@Entity
@Table(name="sales")
public class Sales extends DefaultPersistence{
	
	private Date salesdate;
	private BigDecimal totalsales;
	private Product product;
	
	@Temporal(TemporalType.DATE)
	@Column(name="salesdate", nullable=false)	
	public Date getSalesdate() {
		return salesdate;
	}

	public void setSalesdate(Date salesdate) {
		this.salesdate = salesdate;
	}

	@ManyToOne
	@JoinColumn(name="product_id")	
	public Product getProduct(){
		return product;
	}

	public void setProduct(Product product){
		this.product = product;
	}

	@Column(name="totalsales", nullable=false, precision=18)
	public BigDecimal getTotalsales() {
		return totalsales;
	}

	public void setTotalsales(BigDecimal totalsales) {
		this.totalsales = totalsales;
	}

	
	
	

}
