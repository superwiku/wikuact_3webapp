package org.meruvian.yama.bussiness.repository;

import java.util.List;

import org.meruvian.yama.bussiness.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long>{
	
	Product findById(long id);
	@Query("SELECT n FROM T_PRODUCT n WHERE n.name LIKE %?1%")
	List<Product> findByName(String name);

}
