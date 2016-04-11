package org.meruvian.yama.bussiness.repository;

import org.meruvian.yama.bussiness.entity.Sales;
import org.springframework.data.repository.CrudRepository;

public interface SalesRepository extends CrudRepository<Sales, Long>{
	Sales findById(long id);

}
