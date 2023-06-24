package com.bg.model;

import java.util.Objects;

public class Item {
	private int item_id ;           
	private String item_name;        
	private int price;  
	private int aval_qty; 
	private String img_path;
	
	
	public Item(int item_id, String item_name, int price, int aval_qty, String img_path) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.price = price;
		this.aval_qty = aval_qty;
		this.img_path = img_path;
	}


	public Item() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public int hashCode() {
		return item_id;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Item))
			return false;
		Item other = (Item) obj;
		return item_id == other.item_id;
	}


	public int getItem_id() {
		return item_id;
	}


	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}


	public String getItem_name() {
		return item_name;
	}


	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getAval_qty() {
		return aval_qty;
	}


	public void setAval_qty(int aval_qty) {
		this.aval_qty = aval_qty;
	}


	public String getImg_path() {
		return img_path;
	}


	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}


	@Override
	public String toString() {
		return "Item [item_id=" + item_id + ", item_name=" + item_name + ", price=" + price + "]";
	}


	

}
