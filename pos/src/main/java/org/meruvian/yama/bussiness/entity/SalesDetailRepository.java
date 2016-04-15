package org.meruvian.yama.bussiness.entity;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesDetailRepository extends CrudRepository<SalesDetail, Long>{
	SalesDetail findById(long id);

}
