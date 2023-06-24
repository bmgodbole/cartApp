package com.bg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bg.model.User;
//import com.bgc.webutil.BgcDataAccessException;

public class UserDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public UserDao(Connection con)
	{
		this.con = con;
	}
    public User userLogin(String email,String password)
    {
    	User user = null;
    	try
    	{
    		query="Select * from Users where user_email = ? and user_password = ?";
    		pst = this.con.prepareStatement(query);
    		pst.setString(1,email);
    		pst.setString(2,password);
    		rs = pst.executeQuery();
    		if(rs.next())
    		{
    			user = new User();
    			user.setUser_id(rs.getInt("user_id"));
    			user.setUser_email(rs.getString("user_email"));
    			user.setUser_name(rs.getString("user_name"));
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		
    		System.out.println(e);
    	//	throw new BgcDataAccessException("");
    	}
    	return user;
    }
}
