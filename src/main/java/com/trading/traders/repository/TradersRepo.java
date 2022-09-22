package com.trading.traders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.trading.traders.model.TradersModel;

import javax.transaction.Transactional;


@Repository
public interface TradersRepo extends JpaRepository<TradersModel,Long> {
	@Query(value="select name from TradersModel t where t.email=?1")
	String checkName(String email);
	
	@Query(value="select t from TradersModel t where t.email=?1")
	TradersModel getRecordByEmail(String email);
	
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Transactional
	@Query(value="update TradersModel t set t.name=?1 where t.email=?2")
	int checkUpdated(String name,String email);
	
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Transactional
	@Query(value="update TradersModel t set t.balance=?1 where t.email=?2")
	int addBalance(double balance,String email);

	

}
