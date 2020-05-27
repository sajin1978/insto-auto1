package com.account.fetch_details.entity;

import java.io.Serializable;
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
 * Transactions entity class  
 * @author sajin
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transactions")
public class Transactions implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trans_num")
	private Integer transNumber;
	
	@Column(name = "account_num")
	private Integer accountId;
	
	@Column(name = "account_name")
	private String name;
	
	@Column(name = "value_date")
	private String valdate;
	
	@Column(name = "currency")
	private String currency;
	
	@Column(name = "debit_amt")
	private double debitAmount;
	
	@Column(name = "credit_amt")
	private double creditAmount;
	
	@Column(name = "trans_status")
	private String transStatus;
	
	@Column(name = "trans_desc")
	private String transDesc;

	
}

