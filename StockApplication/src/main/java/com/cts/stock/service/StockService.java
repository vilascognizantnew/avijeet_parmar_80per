package com.cts.stock.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cts.stock.dao.StockRepository;
import com.cts.stock.model.Stock;
@Service
public class StockService {

	@Autowired    
private StockRepository stockRepository;    
//	public List<Stock> getAllStock()  
//	{    
//	List<Stock> stock = new ArrayList<>();    
//	stockRepository.findAll().forEach(stock::add);    
//	return stock;    
//	}
	 
	public List<Stock> allStock(){
		return (List<Stock>) stockRepository.findAll();
	}
	
	public List<Stock> topFiveStock(){
		return (List<Stock>) stockRepository.findTopFiveStocks(0);
	}
	
	public Stock searchStockById(int id){
		Optional<Stock> s = stockRepository.findAllById(id);
		if(s.isPresent()){
			return s.get();
		}
		return null;
	}
	
	public Stock searchStockByName(String name){
		Optional<Stock> s =stockRepository.findByStockName(name);
		if(s.isPresent()){
			return s.get();
		}
		return null;
	}
	
	public List<Stock> searchStockByPrice(Double startPrice, Double endPrice){
		return (List<Stock>) stockRepository.findByPriceBetween(startPrice,endPrice);
	}

	public List<Stock> searchStockByDate(Date startDate, Date endDate){
		return (List<Stock>) stockRepository.findByDateBetween(startDate,endDate);
	}
}
