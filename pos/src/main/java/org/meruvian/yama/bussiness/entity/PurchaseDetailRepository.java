package org.meruvian.yama.bussiness.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseDetailRepository extends CrudRepository<PurchaseDetail, Long>{
	PurchaseDetail findById(long id);

}
