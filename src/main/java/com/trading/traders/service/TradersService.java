package com.trading.traders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import com.trading.traders.model.TradersModel;
import com.trading.traders.repository.TradersRepo;

import Exceptions.InvalidEmailException;

import java.util.List;

@Service
public class TradersService {
	
	@Autowired
	private TradersRepo traders;
	
	public TradersModel createTraderService( TradersModel trader){
		
		System.out.println(traders.checkName(trader.getEmail()));
		if(traders.checkName(trader.getEmail())==null) {
			traders.save(trader);
			return trader;

		}
		
			throw new InvalidEmailException("user already exists with email");
	}
	
		

	public List<TradersModel> getAllTradersService() {
		// TODO Auto-generated method stub
//		System.out.println(traders.findAll());
//		return (List) traders.findAll();
		
		return traders.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public TradersModel getRecordByEmail(String email) {
//		 TODO Auto-generated method stub
		TradersModel model=traders.getRecordByEmail(email);
		if(null==model) {
			throw  new InvalidEmailException("invalid user email"+email);
		}
		return model;
	}
	
	public TradersModel updatetraderservice( @Validated@RequestBody TradersModel trader) {
		// TODO Auto-generated method stub
	if(traders.checkUpdated(trader.getName(),trader.getEmail())==0) {
		throw new InvalidEmailException("user not found with email");

	}
		return trader;
	}
         
	
//
	public TradersModel addbalanceservice(@Validated@RequestBody TradersModel trader) {
		// TODO Auto-generated method stub
	if(traders.addBalance(trader.getBalance(), trader.getEmail())==0) {
		throw  new InvalidEmailException("name should not change");
	}
	   return  trader;
//
	}
}

	


