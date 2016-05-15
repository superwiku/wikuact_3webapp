package org.meruvian.yama.webapi.service.purchase;

import java.math.BigDecimal;
import java.util.Date;

import javax.inject.Inject;
import javax.ws.rs.BadRequestException;

import org.apache.commons.lang3.StringUtils;
import org.meruvian.yama.bussiness.entity.Purchase;
import org.meruvian.yama.bussiness.entity.PurchaseRepository;
import org.meruvian.yama.core.LogInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RestPurchaseService implements PurchaseService {
	@Inject
	private PurchaseRepository purchaserepository;
	
	@Override
	public Purchase getPurchaseById(String id) {
		return purchaserepository.findById(id);
	}
	
	@Override
	@Transactional
	public Purchase updatePurchase(Purchase purchase) {
		Purchase awal = getPurchaseById(purchase.getId());
		if (awal != null) {
			awal.setPurchasedate(purchase.getPurchasedate());
			awal.setTotalpurchase(purchase.getTotalpurchase());
			
		}
		
		return awal;
	}
	
	@Override
	@Transactional
	public Purchase savePurchase(Purchase purchase){
		if (StringUtils.isBlank(purchase.getId())) {
			purchase.setId(null);
			purchase.setPurchasedate(new Date());
			return purchaserepository.save(purchase);
		}
		
		throw new BadRequestException("Id must be empty, use PUT method to update record");
	}
	
	@Override
	@Transactional
	public void deletePurchase(String id) {
		getPurchaseById(id).getLogInformation().setActiveFlag(LogInformation.INACTIVE);;
	}

	@Override
	public Page<Purchase> findPurchaseByPurchasedate(Date purchasedate, Pageable pageable) {
		// TODO Auto-generated method stub
		return purchaserepository.findByPurchasedate(purchasedate, LogInformation.ACTIVE, pageable);
	}

	@Override
	public Page<Purchase> findPurchaseByTotalpurchase(BigDecimal totalpurchase,  Pageable pageable) {
		// TODO Auto-generated method stub
		return purchaserepository.findByTotalpurchase(totalpurchase, LogInformation.ACTIVE, pageable);
	}

}
