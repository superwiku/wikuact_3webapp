package org.meruvian.yama.webapi.service.salesdetail;

import javax.inject.Inject;
import javax.ws.rs.BadRequestException;

import org.apache.commons.lang3.StringUtils;
import org.meruvian.yama.bussiness.entity.SalesDetail;
import org.meruvian.yama.bussiness.entity.SalesDetailRepository;
import org.meruvian.yama.core.LogInformation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RestSalesDetailService implements SalesDetailService{
	
	@Inject
	private SalesDetailRepository salesdetailrepository;
	
	@Override
	public SalesDetail getSalesDetailById(String id) {
		return salesdetailrepository.getById(id);
	}
	
	@Override
	@Transactional
	public SalesDetail updateSalesDetail(String id, SalesDetail salesdetail) {
		SalesDetail awal = getSalesDetailById(salesdetail.getId());
		if (awal != null) {
			awal.setQuantity(salesdetail.getQuantity());
			awal.setPrice(salesdetail.getPrice());
			awal.setSubTotal(salesdetail.getSubTotal());
			
		}
		
		return awal;
	}
	
	@Override
	@Transactional
	public SalesDetail saveSalesDetail(SalesDetail salesdetail){
		if (StringUtils.isBlank(salesdetail.getId())) {
			salesdetail.setId(null);
			salesdetail.setSales(salesdetail.getSales());
			return salesdetailrepository.save(salesdetail);
		}
		
		throw new BadRequestException("Id must be empty, use PUT method to update record");
	}
	
	@Override
	@Transactional
	public void deleteSalesDetail(String id) {
		getSalesDetailById(id).getLogInformation().setActiveFlag(LogInformation.INACTIVE);
	}


}
