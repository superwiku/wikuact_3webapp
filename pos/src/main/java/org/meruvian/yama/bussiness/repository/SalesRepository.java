package org.meruvian.yama.bussiness.repository;

import org.meruvian.yama.bussiness.entity.Sales;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends CrudRepository<Sales, Long>{
	Sales findById(long id);

}
