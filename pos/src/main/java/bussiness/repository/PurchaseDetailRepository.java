package bussiness.repository;

import bussiness.entity.Purchase;
import bussiness.entity.PurchaseDetail;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseDetailRepository extends CrudRepository<PurchaseDetail, Long>{
	PurchaseDetail findById(long id);

}
