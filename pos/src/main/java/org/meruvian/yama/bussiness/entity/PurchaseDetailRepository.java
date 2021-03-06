package org.meruvian.yama.bussiness.entity;

import org.meruvian.yama.core.DefaultRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseDetailRepository extends DefaultRepository<PurchaseDetail>{
	PurchaseDetail getById(String id);
	
	@Query("Select a FROM PurchaseDetail a WHERE a.purchase.id = ?1 And a.logInformation.activeFlag = ?2")
	Page<PurchaseDetail> findByPurchaseId(String id, int activeFlag, Pageable pageable);

}
