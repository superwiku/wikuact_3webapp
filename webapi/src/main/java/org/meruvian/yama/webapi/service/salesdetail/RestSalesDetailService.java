package org.meruvian.yama.webapi.service.salesdetail;

import javax.inject.Inject;

import org.meruvian.yama.bussiness.entity.SalesDetail;
import org.meruvian.yama.bussiness.entity.SalesDetailRepository;
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
			awal.setProduct(salesdetail.getProduct());
			awal.setQuantity(salesdetail.getQuantity());
			awal.setPrice(salesdetail.getPrice());
			awal.setSubTotal(salesdetail.getSubTotal());
			
		}
		
		return awal;
	}
	
	@Override
	@Transactional
	public SalesDetail saveSalesDetail(SalesDetail salesdetail){
		return salesdetailrepository.save(salesdetail);
	}
	
	@Override
	@Transactional
	public void deleteSalesDetail(String id) {
		salesdetailrepository.delete(id);
	}


}
