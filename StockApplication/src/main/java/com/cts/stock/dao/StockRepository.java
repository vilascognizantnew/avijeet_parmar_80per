package com.cts.stock.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.stock.model.Stock;
@Repository
public interface StockRepository extends CrudRepository<Stock, String>{

	List<Stock> findTopFiveStocks(float price);

	List<Stock> findByID(int id);

	List<Stock> findByStockName(String name);

	Iterable<Stock> findAll();
	public List<Stock> findByPriceBetween(Double startPrice, Double endPrice);
	
	List<Stock> findByDateBetween(Date startDate, Date endDate);
	
}
