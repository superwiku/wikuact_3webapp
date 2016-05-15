package org.meruvian.yama.webapi.service.sales;

import java.util.Date;

import javax.inject.Inject;
import javax.ws.rs.BadRequestException;

import org.apache.commons.lang3.StringUtils;
import org.meruvian.yama.bussiness.entity.Sales;
import org.meruvian.yama.bussiness.entity.SalesDetail;
import org.meruvian.yama.bussiness.entity.SalesDetailRepository;
import org.meruvian.yama.bussiness.entity.SalesRepository;
import org.meruvian.yama.core.LogInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RestSalesService implements SalesService{
	@Inject
	private SalesRepository salesrepository;
	
	@Inject
	private SalesDetailRepository salesdetailrepository;
	
	@Override
	public Sales getSalesById(String id) {
		return salesrepository.getById(id);
	}
	
	@Override
	@Transactional
	public Sales updateSales(String id, Sales sales) {
		Sales awal = getSalesById(sales.getId());
		if (awal != null) {
			awal.setSalesdate(sales.getSalesdate());
			awal.setTotalsales(sales.getTotalsales());
			return salesrepository.save(awal);
		}
		
		return awal;
	}
	
	@Override
	@Transactional
	public Sales saveSales(Sales sales){
		if (StringUtils.isBlank(sales.getId())) {
			sales.setId(null);
			return salesrepository.save(sales);
		}
		
		throw new BadRequestException("Id must be empty, use PUT method to update record");
	}
	
	@Override
	@Transactional
	public void deleteSales(String id) {
		getSalesById(id).getLogInformation().setActiveFlag(LogInformation.INACTIVE);;
	}

	@Override
	public Page<Sales> findSalesBySalesdate(Date salesdate, Pageable pageable) {
		// TODO Auto-generated method stub
		return salesrepository.findBySalesdate(salesdate, LogInformation.ACTIVE, pageable);
	}

	@Override
	public Page<SalesDetail> findSalesDetailBySales(String id, Pageable pageable) {
		// TODO Auto-generated method stub
		return salesdetailrepository.findBySalesId(id, LogInformation.ACTIVE, pageable);
	}

}
