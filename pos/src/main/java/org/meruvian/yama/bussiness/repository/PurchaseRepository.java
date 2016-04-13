package org.meruvian.yama.bussiness.repository;

import org.meruvian.yama.bussiness.entity.Purchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Long>{
	Purchase findById(long id);

}
