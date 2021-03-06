package org.meruvian.yama.bussiness.entity;

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
	private Double totalpurchase;
	
	public Date getPurchasedate() {
		return purchasedate;
	}

	public void setPurchasedate(Date purchasedate) {
		this.purchasedate = purchasedate;
	}

	public Double getTotalpurchase() {
		return totalpurchase;
	}

	public void setTotalpurchase(Double totalpurchase) {
		this.totalpurchase = totalpurchase;
	}

	
}
