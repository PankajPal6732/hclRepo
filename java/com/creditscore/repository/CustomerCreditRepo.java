package com.creditscore.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.creditscore.entity.CustomerCreditDetail;

@Repository
public interface CustomerCreditRepo extends CrudRepository<CustomerCreditDetail, String> {

	@Query(nativeQuery=true,value="SELECT count(*) from UserDetails where Created_Ts >trunc(sysdate-30)")
	public Integer getCountBySsnNumAndDateRange(String ssnNumber);
}
