package com.bg.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bg.model.CartItem;
import com.bg.model.Order;
import com.bg.model.User;

/**
 * Servlet implementation class RemoveFromCart
 */
@WebServlet("/remove-from-cart")
public class RemoveFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    //response.getWriter().print(request.getParameter("id"));
	    int id = Integer.parseInt(request.getParameter("id"));
	    ArrayList<CartItem> cart_list  = (ArrayList<CartItem>)request.getSession().getAttribute("cart-list");
	    User auth = (User) request.getSession().getAttribute("auth");
	    if(auth !=null)
	    {
	       if(id>0)
	       {
	    	   int qty = (int) request.getAttribute("quantity");
	    	   Date dt = new Date();
	           Order orderModel = new Order();
	           orderModel.setOrderId(id); //id should come from database
	           //right now setting it equal to product id.
	           orderModel.setQuantity(qty);
	           orderModel.setDate(dt);
	           //use formatter for date
	           orderModel.setUid(auth.getUser_id()); 
	    }
	    else {
	        response.sendRedirect("login.jsp");
	    }
	 }
	}
}
