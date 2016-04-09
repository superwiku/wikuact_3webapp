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
@Table(name="T_SALES")
public class Sales{
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="SALES_DATE", nullable=false)
	private Date salesdate;
	
	@Column(name="TOTAL_SALES", nullable=false, precision=18)
	private BigDecimal totalsales;
	
	@OneToMany(mappedBy="sales", cascade=CascadeType.ALL)
	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<SalesDetail> salesdetail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getSalesDate() {
		return salesdate;
	}

	public void setSalesDate(Date salesdate) {
		this.salesdate = salesdate;
	}

	public BigDecimal getTotalSales() {
		return totalsales;
	}

	public void setTotalSales(BigDecimal totalsales) {
		this.totalsales = totalsales;
	}

	public List<SalesDetail> getSalesDetail() {
		return salesdetail;
	}

	public void setSalesDetail(List<SalesDetail> salesdetail) {
		this.salesdetail = salesdetail;
	}
	
	

}
