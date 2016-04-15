package org.meruvian.yama.webapi.service.purchase;

import javax.inject.Inject;

import org.meruvian.yama.bussiness.entity.Purchase;
import org.meruvian.yama.bussiness.entity.PurchaseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RestPurchaseService implements PurchaseService {
	@Inject
	private PurchaseRepository purchaserepository;
	
	@Override
	public Purchase getPurchaseById(long id) {
		return purchaserepository.findById(id);
	}
	
	@Override
	@Transactional
	public Purchase updatePurchase(long id, Purchase purchase) {
		Purchase awal = getPurchaseById(purchase.getId());
		if (awal != null) {
			awal.setPurchaseDate(purchase.getPurchaseDate());
			awal.setTotalPurchase(purchase.getTotalPurchase());
			
		}
		
		return awal;
	}
	
	@Override
	@Transactional
	public Purchase savePurchase(Purchase purchase){
		return purchaserepository.save(purchase);
	}
	
	@Override
	@Transactional
	public void deletePurchase(long id) {
		purchaserepository.delete(id);
	}

}
