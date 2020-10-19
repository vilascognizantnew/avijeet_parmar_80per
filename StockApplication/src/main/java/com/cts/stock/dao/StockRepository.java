package com.cts.stock.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.stock.model.Stock;
@Repository
public interface StockRepository extends CrudRepository<Stock, String>{

	List<Stock> findTop5ByPrice(float price);

	List<Stock> findByID(int id);

	List<Stock> findByName(String name);

	Iterable<Stock> findAll();
	
	List<Stock> findByAgeBetween(Integer startAge, Integer endAge);
	
}
