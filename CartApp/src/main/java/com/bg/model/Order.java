package com.bg.model;

import java.util.Date;

public class Order {
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getQuantity() {
		return quantity;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", uid=" + uid + ", quantity=" + quantity + ", date=" + date
				+ ", orderTotal=" + orderTotal + "]";
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date dt) {
		this.date = dt;
	}
	public int getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}
	private int orderId;
	private int uid;
	private int quantity;
	private Date date;
	private int orderTotal;
    private int itemId;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
}
