package com.account.fetch_details.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Account entity class  
 * @author sajin
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
public class Account implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_num")
	private Integer accountId;
	
	@Column(name = "account_name")
	private String name;
	
	
	@Column(name = "account_type")
	private String type;
	
	@Column(name = "balance")
	private double balance;
	
	@Column(name = "balance_date")
	private Date balanceDate;
	
	@Column(name = "currency")
	private String currency;
	
}

