package org.meruvian.yama.bussiness.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="T_PURCHASE")
public class Purchase {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="PURCHASE_DATE")
	private Date purchasedate;
	
	@Column(name="TOTAL_PURCHASE", nullable=false, precision=18, scale=0)
	private BigDecimal totalpurchase;
	
	@OneToMany(mappedBy="purchase", cascade=CascadeType.ALL)
	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<PurchaseDetail> purchasedetail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPurchaseDate() {
		return purchasedate;
	}

	public void setPurchaseDate(Date purchasedate) {
		this.purchasedate = purchasedate;
	}

	public BigDecimal getTotalPurchase() {
		return totalpurchase;
	}

	public void setTotalPurchase(BigDecimal totalpurchase) {
		this.totalpurchase = totalpurchase;
	}

	public List<PurchaseDetail> getPurchasedetail() {
		return purchasedetail;
	}

	public void setPurchasedetail(List<PurchaseDetail> purchasedetail) {
		this.purchasedetail = purchasedetail;
	}
	
	

}
