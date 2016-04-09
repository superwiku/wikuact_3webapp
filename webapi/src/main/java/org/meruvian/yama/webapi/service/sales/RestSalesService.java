package org.meruvian.yama.webapi.service.sales;

import javax.inject.Inject;

import org.meruvian.yama.bussiness.entity.Sales;
import org.meruvian.yama.bussiness.repository.SalesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RestSalesService implements SalesService{
	@Inject
	private SalesRepository salesrepository;
	
	@Override
	public Sales getSalesById(long id) {
		return salesrepository.findById(id);
	}
	
	@Override
	@Transactional
	public Sales updateSales(long id, Sales sales) {
		Sales awal = getSalesById(sales.getId());
		if (awal != null) {
			awal.setSalesDate(sales.getSalesDate());
			awal.setTotalSales(sales.getTotalSales());
			
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
	public void deleteSales(long id) {
		salesrepository.delete(id);
	}

}
