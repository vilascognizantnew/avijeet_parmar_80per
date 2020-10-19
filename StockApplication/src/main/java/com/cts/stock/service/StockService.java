package com.cts.stock.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cts.stock.dao.StockRepository;
import com.cts.stock.model.Stock;
@Service
public class StockService {

	@Autowired    
	private StockRepository stockRepository;    
	public List<Stock> getAllStock()  
	{    
	List<Stock> stock = new ArrayList<>();    
	stockRepository.findAll().forEach(stock::add);    
	return stock;    
	}
	 
}
