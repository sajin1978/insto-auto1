package com.account.fetch_details.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.account.fetch_details.dao.AccountDao;
import com.account.fetch_details.dao.TransactionsDao;
import com.account.fetch_details.entity.Account;
import com.account.fetch_details.entity.Transactions;
import com.account.fetch_details.service.FetchAccountDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * The Class FetchAccountDetailsControllerTest to unit test all the APIs in
 * FetchAccountDetailsController
 * 
 * @author sajin 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class FetchAccountDetailsControllerTest {
	
	
	@Autowired
	MockMvc mockMvc;
	
	@InjectMocks
	FetchAccountDetailsService fetchAccountDetailsService;
	
	@Value("${baseUrlValtest}")
	private String baseUrlVal;
	
	
	@MockBean
	AccountDao accountDao;
	
	@MockBean
	TransactionsDao accountTransactionsDao;
	
	
	private static List<Object> dataAccounts = new ArrayList<Object>();
	private static Account accountPagination_1 = null;
	private static final String baseAccountUrl = "/accounts";
	private static final String baseAccountTransactionUrl = "/accounts/transactions";
	private static Transactions transaction1 = null; 
	private static List<Object> dataAccountTransactions = new ArrayList<Object>();
	private static List<Account> accountPoolList = new ArrayList<Account>();
	
	@BeforeClass
	public static void initializeTestData() {
		Date currentDate = new Date();
		accountPagination_1 = new Account(1,"testaccountname1", "testacttype1", 1111.11, currentDate, "Rupees");
		accountPoolList.add(accountPagination_1);
		dataAccounts.add(accountPagination_1);
		transaction1 = new Transactions(1,1,"testaccounttransactionname","02-02-2020","rupees",1111.11,0,"debit","debit transaction");
		dataAccountTransactions.add(transaction1);
	}
	
	
	@Test
	public void getAccounts() throws Exception {
		final Page<Account> pageReq = new PageImpl<>(accountPoolList);
		Mockito.when(accountDao.findAll(Mockito.any(PageRequest.class))).thenReturn(pageReq);
		Mockito.when(accountDao.count()).thenReturn((long) accountPoolList.size());
		mockMvc.perform(get(baseUrlVal + baseAccountUrl).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	
	@Test
	public void getAccountTransactions() throws Exception {
		
		Mockito.when(accountTransactionsDao.getByAccountId(Mockito.anyInt())).thenReturn(Optional.of(transaction1));
		
	    mockMvc.perform(get(baseUrlVal + baseAccountTransactionUrl+"/{accountid}",1).contentType(MediaType.APPLICATION_JSON)
	    		.content(new ObjectMapper().writeValueAsString(transaction1)))

	    .andExpect(status().isOk());
	    
	}
	
	@AfterClass
	public static void resetTestData() {
		accountPagination_1 = null;
		transaction1 = null;
		accountPoolList.clear();
		dataAccountTransactions.clear();
		dataAccountTransactions.clear();
	}
	

}

