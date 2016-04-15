package org.meruvian.yama.webapi.service.purchasedetail;

import javax.inject.Inject;

import org.meruvian.yama.bussiness.entity.PurchaseDetail;
import org.meruvian.yama.bussiness.entity.PurchaseDetailRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class RestPurchaseDetailService implements PurchaseDetailService{
	
	@Inject
	private PurchaseDetailRepository purchasedetailrepository;
	
	@Override
	public PurchaseDetail getPurchaseDetailById(long id) {
		return purchasedetailrepository.findById(id);
	}
	
	@Override
	@Transactional
	public PurchaseDetail savePurchaseDetail(PurchaseDetail purchasedetail){
		return purchasedetailrepository.save(purchasedetail);
	}
	
	@Override
	@Transactional
	public void deletePurchaseDetail(long id) {
		purchasedetailrepository.delete(id);
	}
	
	@Override
	@Transactional
	public PurchaseDetail updatePurchaseDetail(long id, PurchaseDetail purchasedetail) {
		PurchaseDetail awal = getPurchaseDetailById(purchasedetail.getId());
		if (awal != null) {
			awal.setQuantity(purchasedetail.getQuantity());
			awal.setPrice(purchasedetail.getPrice());
			awal.setSubtotal(purchasedetail.getSubtotal());
		}
		
		return awal;
	}

}
