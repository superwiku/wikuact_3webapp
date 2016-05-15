package org.meruvian.yama.bussiness.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.meruvian.yama.core.DefaultRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends DefaultRepository<Purchase>{
	@Query("Select p from Purchase p where p.purchasedate BETWEEN ?1 AND ?2 AND p.logInformation.activeFlag = ?3")
	Page<Purchase> findByPurchasedate(Date purchasedate, int activeFlag, Pageable pageable);
	
	@Query("Select z from Purchase z where z.totalpurchase BETWEEN ?1 AND ?2 AND z.logInformation.activeFlag = ?3")
	Page<Purchase> findByTotalpurchase(BigDecimal totalpurchase, int activeFlag, Pageable pageable);

}
