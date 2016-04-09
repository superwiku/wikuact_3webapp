package bussiness.repository;


import bussiness.entity.SalesDetail;
import org.springframework.data.repository.CrudRepository;

public interface SalesDetailRepository extends CrudRepository<SalesDetail, Long>{
	SalesDetail findById(long id);

}
