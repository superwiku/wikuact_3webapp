package org.meruvian.yama.webapi.service.sales;

import java.util.Date;

import javax.inject.Inject;

import org.meruvian.yama.bussiness.entity.Sales;
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
			
		}
		
		return awal;
	}
	
	@Override
	@Transactional
	public Sales saveSales(Sales sales){
		return salesrepository.save(sales);
	}
	
	@Override
	@Transactional
	public void deleteSales(String id) {
		salesrepository.delete(id);
	}

	@Override
	public Page<Sales> findSalesBySalesdate(Date salesdatemin,Date salesdatemax, Pageable pageable) {
		// TODO Auto-generated method stub
		return salesrepository.findBySalesdate(salesdatemin, salesdatemax, LogInformation.ACTIVE, pageable);
	}

}
