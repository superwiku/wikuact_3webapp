package org.meruvian.yama.bussiness.repository;

import org.meruvian.yama.bussiness.entity.Purchase;
import org.meruvian.yama.bussiness.entity.PurchaseDetail;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseDetailRepository extends CrudRepository<PurchaseDetail, Long>{
	PurchaseDetail findById(long id);

}
