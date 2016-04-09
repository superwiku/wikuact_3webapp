package bussiness.repository;

import bussiness.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository extends CrudRepository<Purchase, Long>{
	Purchase findById(long id);

}
