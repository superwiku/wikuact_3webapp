package org.meruvian.yama.bussiness.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.meruvian.yama.core.DefaultPersistence;

@Entity
@Table(name = "purchase")
public class Purchase extends DefaultPersistence {

	private Date purchasedate;
	private BigDecimal totalpurchase;

	@Temporal(TemporalType.DATE)
	public Date getPurchasedate() {
		return purchasedate;
	}

	public void setPurchasedate(Date purchasedate) {
		this.purchasedate = purchasedate;
	}

	@Column(name="totalpurchase", nullable=false, precision=18, scale=0)
	public BigDecimal getTotalpurchase() {
		return totalpurchase;
	}

	public void setTotalpurchase(BigDecimal totalpurchase) {
		this.totalpurchase = totalpurchase;
	}

}
