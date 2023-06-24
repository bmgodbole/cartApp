package com.bg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bg.model.CartItem;
import com.bg.model.Item;

public class ItemDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ItemDao(Connection con)
	{
		this.con = con;
	}

	public int getCartTotal(ArrayList<CartItem> crtList)
	{
		int sum= 0;
		if(crtList.size()>0)
		{
			for(CartItem c:crtList)
			{
				sum+=c.getTotal_price();
			}
		}
		return sum;
		
	}
	public List<CartItem> getCartProducts(ArrayList<CartItem> cartList) 
	{
		List<CartItem> cartProducts = new ArrayList<CartItem>();
		if (cartList.size()>0)
		{
			for(CartItem c:cartList)
			{
				query = "select * from items where item_id =?";
				try {
					pst = this.con.prepareStatement(query);
				    pst.setInt(1, c.getItemId());
				    rs=pst.executeQuery();
				    while(rs.next())
				    {
				    	CartItem row= new CartItem();
				    	row.setItemId(rs.getInt("item_id"));
				    	row.setItem_id(rs.getInt("item_id"));
						row.setItem_name(rs.getString("item_name"));
						row.setPrice(rs.getInt("price"));
						row.setTotal_price(rs.getInt("price")*c.getQuantity());
				        row.setQuantity(c.getQuantity());
						cartProducts.add(row);	  
				    }
		
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("ItemDao line 53"+cartProducts);
		return cartProducts;
		
	}
	public List<Item> getAllItems()
	{
		List<Item> items = new ArrayList<Item>();
		
		try
		{
			query = "Select * from items";
			pst = this.con.prepareCall(query);
			rs = pst.executeQuery();
			while(rs.next())
			{
				Item row = new Item();
				row.setItem_id(rs.getInt("item_id"));
				row.setItem_name(rs.getString("item_name"));
				row.setPrice(rs.getInt("price"));
				row.setAval_qty(rs.getInt("aval_qty"));
				row.setImg_path(rs.getString("img_path"));
				items.add(row);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return items;
		
	}
}
