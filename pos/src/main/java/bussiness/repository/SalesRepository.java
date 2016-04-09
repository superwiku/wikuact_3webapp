package bussiness.repository;

import bussiness.entity.Sales;
import org.springframework.data.repository.CrudRepository;

public interface SalesRepository extends CrudRepository<Sales, Long>{
	Sales findById(long id);

}
