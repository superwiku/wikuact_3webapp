package org.meruvian.yama.bussiness.entity;


import org.meruvian.yama.core.DefaultRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesDetailRepository extends DefaultRepository<SalesDetail>{
	SalesDetail getById(String id);
	Page<SalesDetail> findBySalesId(String id, int activeFlag, Pageable pageable);
}
