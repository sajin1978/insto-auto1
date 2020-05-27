package com.account.fetch_details.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account.fetch_details.entity.Account;
/**
 * AccountDao class 
 * @author sajin 
 */
public interface AccountDao extends JpaRepository<Account, Integer> {

}
