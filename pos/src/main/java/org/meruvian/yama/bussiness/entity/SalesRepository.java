package org.meruvian.yama.bussiness.entity;

import java.util.Date;

import org.meruvian.yama.core.DefaultRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends DefaultRepository<Sales>{
	
	@Query("Select s from Sales s where s.totalsales < ?1 OR s.logInformation.activeFlag = ?2")
	Page<Sales>findByTotalsales(Double totalsales, int activeFlag, Pageable pageable);
	
	@Query("Select s from Sales s where s.salesdate BETWEEN ?1 AND ?2 AND s.logInformation.activeFlag = ?3")
	Page<Sales> findBySalesdatespan(Date salesdatemin, Date salesdatemax, int activeFlag, Pageable pageable);

	@Query("Select z from Sales z where z.totalsales BETWEEN ?1 AND ?2 AND z.logInformation.activeFlag = ?3")
	Page<Sales> findByTotalsalesspan(Double totalsalesmin, Double totalsalesmax, int activeFlag, Pageable pageable);
}
