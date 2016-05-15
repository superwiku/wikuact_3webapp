package org.meruvian.yama.bussiness.entity;

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
	private Double totalsales;
	

	@Column(name="salesdate")	
	public Date getSalesdate() {
		return salesdate;
	}

	public void setSalesdate(Date salesdate) {
		this.salesdate = salesdate;
	}

	@Column(name="totalsales")
	public Double getTotalsales() {
		return totalsales;
	}

	public void setTotalsales(Double totalsales) {
		this.totalsales = totalsales;
	}
}
