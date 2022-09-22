package com.trading.traders.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Traders")

@NoArgsConstructor 
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class TradersModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	private String name;
	private String email;
	private double balance;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss Z", timezone = "Asia/Kolkata")
	private Date createdAt = new Date();
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss Z", timezone = "Asia/Kolkata")
   	private Date updatedAt = new Date();
		public String getEmail() {
		return email;
	}
	public void setEmail(String Email) {
		this.email = Email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public TradersModel get() {
		// TODO Auto-generated method stub
		return null;
	}


}
