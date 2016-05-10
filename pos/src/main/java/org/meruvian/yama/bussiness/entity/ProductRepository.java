package org.meruvian.yama.bussiness.entity;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	Product getById(Long id);	
	List<Product> findByName(String name);
	List<Product> findByNameAndPrice(String name, BigDecimal price);

}
