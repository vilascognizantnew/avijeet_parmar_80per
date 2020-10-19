package com.cts.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.stock.model.Stock;
import com.cts.stock.service.StockService;

@RestController
public class StockController {

	@Autowired    
	private StockService stockService;     
	
	
	@GetMapping(value = "/stockList")
	public ResponseEntity<Object> stockList()
	{
		
		return new ResponseEntity<>(stockService.getAllStock(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/getStocksById/id/{id}/name/{name}")
	public ResponseEntity<Object> personList(@PathVariable("id") Integer id)
	{
		
			Stock stock=stockService.getStockById(id);
			if(stock!=null) {
				
				return new ResponseEntity<>(stock,HttpStatus.OK);	
			}
			else
			return new ResponseEntity<>("Resord Not Found",HttpStatus.OK);
				
	}
	
	
	@GetMapping(value="/searchStockByName/{name}")
	public ResponseEntity<?> searchStockById(@PathVariable("name") String name)
	{
		Stock s = stockService.searchStockByName(name);
		if(s==null){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Stock>(s,HttpStatus.OK);
	}

	@GetMapping(value="/searchStockByPrice/{startPrice}/{endPrice}")
	public ResponseEntity<?> searchStockByPrice(@PathVariable("startPrice") Double startPrice, @PathVariable("endPrice") Double endPrice )
	{
		List<Stock> s = stockService.searchStockByPrice(startPrice,endPrice);
		if(s.size()==0){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Stock>>(s,HttpStatus.OK);
	}
	
	@GetMapping(value="/searchStockByDate/{startDate}/{endDate}")
	public ResponseEntity<?> searchStockById(@PathVariable("startDate") Date startDate, @PathVariable("endDate") Date endDate )
	{
		List<Stock> s = stockService.searchStockByDate(startDate,endDate);
		if(s.size()==0){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Stock>>(s,HttpStatus.OK);
	}
	
	@GetMapping(value="/topFiveStocks")
	public ResponseEntity<?> topFiveStocks()
	{
		return new ResponseEntity List<Stock>(stockService.topFiveStock(),HttpStatus.OK);
	}
}

