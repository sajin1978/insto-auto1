package com.account.fetch_details.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.account.fetch_details.dao.AccountDao;
import com.account.fetch_details.dao.TransactionsDao;
import com.account.fetch_details.entity.Account;
import com.account.fetch_details.entity.Transactions;

/**
 * FetchAccountDetailsService class 
 * @author sajin
 */
@Service
public class FetchAccountDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(FetchAccountDetailsService.class);

	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	TransactionsDao accountTransactionsDao;
	
	 /**
	  * @return Get the account details
	  */
	public List<Account> getAccounts() {
		logger.info("FetchAccountDetailsService : getting accounts");
		List<Account>  accountList = accountDao.findAll();
		logger.info("FetchAccountDetailsService : got accounts");
		return accountList;
		
	}
	
	/**
	 *  @param accountid
	 *  @return Get the transaction details based upon accountid
	 */
	public Optional<Transactions> getAccountTransactionDetails(Integer accountid){
		logger.info("Inside FetchAccountDetailsService-->getAccountTransactionDetails method ");
		return accountTransactionsDao.getByAccountId(accountid);
	}

}
