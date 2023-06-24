package com.bg.model;

import java.util.Objects;

public class CartItem extends Item{
	@Override
	public String toString() {
	    super.toString(); 
		return "CartItem [quantity=" + quantity + ", itemId=" + itemId + ", total_price=" + total_price + "]";
	}

	private int quantity;
    private int itemId;
	private int total_price;
	
    @Override
    public boolean equals(Object obj) {
       
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        CartItem other = (CartItem) obj;
        return itemId == other.itemId ;
    }

	public CartItem()
	{	
}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

   
}
