package com.account.fetch_details.dao;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.account.fetch_details.entity.Transactions;
/**
 * TransactionsDao class 
 * @author sajin 
 */
public interface TransactionsDao extends JpaRepository<Transactions, Integer> {
	
	@Transactional
	public Optional<Transactions> getByAccountId(Integer accountId);

}
