package org.meruvian.yama.bussiness.repository;

import org.meruvian.yama.bussiness.entity.PurchaseDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseDetailRepository extends CrudRepository<PurchaseDetail, Long>{
	PurchaseDetail findById(long id);

}
