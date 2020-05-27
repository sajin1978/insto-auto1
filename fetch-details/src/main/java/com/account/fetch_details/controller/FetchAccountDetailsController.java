package com.account.fetch_details.controller;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.account.fetch_details.entity.Account;
import com.account.fetch_details.entity.Transactions;
import com.account.fetch_details.service.FetchAccountDetailsService;

/**
 * FetchAccountDetailsController class 
 *
 * @author sajin 
 */
@RestController
@RequestMapping("accounts")
public class FetchAccountDetailsController {
	
	private static final Logger logger = LoggerFactory.getLogger(FetchAccountDetailsController.class);

	
	@Autowired
	FetchAccountDetailsService fetchAccountDetailsService;

	 /**
	 * @return Get the account details
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Account>> getAccounts() {
		logger.info("FetchAccountDetailsController : getting accounts");
		List<Account>  accountList = fetchAccountDetailsService.getAccounts();
		logger.info("FetchAccountDetailsController : got accounts details");
		return new ResponseEntity<List<Account>>(accountList,  HttpStatus.OK);
	}
	
	/**
	 *  @param accountid
	 *  @return Get the transaction details based upon accountid
	 */
	@RequestMapping(value="/transactions/{accountid}",method = RequestMethod.GET)
	
	public Optional<Transactions> getAccountTransactions(@PathVariable Integer accountid) {
		logger.info("FetchAccountDetailsController : getting accounts transaction details accountid {}",accountid);
		return fetchAccountDetailsService.getAccountTransactionDetails(accountid);
	}
	
}
