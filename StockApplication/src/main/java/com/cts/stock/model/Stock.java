package com.cts.stock.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Stock {
	
	@Id
	private int id;
	private String name;
	private float price;
	private int volume;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Stock(int id, String name, float price, int volume, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.volume = volume;
		this.date = date;
	}
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Stock [id=" + id + ", name=" + name + ", price=" + price + ", volume=" + volume + ", date=" + date
				+ "]";
	}
	
	
	
	

}
