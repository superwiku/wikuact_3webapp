package org.meruvian.yama.bussiness.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends CrudRepository<Sales, Long>{
	Sales findById(long id);

}
