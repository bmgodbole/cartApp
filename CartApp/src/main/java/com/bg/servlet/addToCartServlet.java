package com.bg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.bg.model.CartItem;
import com.bg.model.Item;

/**
 * Servlet implementation class addToCartServlet
 */
@WebServlet("/add-to-cart")
public class addToCartServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) 
        {
        	response.setContentType("text/html;charset=UTF-8");
        	int id = Integer.parseInt(request.getParameter("id"));
        	
        	
        	//check if cart list already exist or first time creation
        	HttpSession session=request.getSession();
	        ArrayList<CartItem> cartList = (ArrayList<CartItem>)session.getAttribute("cart-list");
            if(cartList==null) {
            	cartList = new ArrayList<CartItem>();
            	CartItem citem = new CartItem();
            	citem.setItem_id(id);
            	citem.setQuantity(1);
            	citem.setItemId(id);
            
            	session.setAttribute("cart-list", cartList);
                System.out.println("session created and list added");		
                cartList.add(citem);
            }
            else
            {
            	 System.out.println("cart list exists");
            	 // if(cartList.contains(citem))
             	// {
             	//	citem.setQuantity(citem.getQuantity()+1);
             	//	System.out.println("item exists");
             	 //}
             	 //else
             	// {		 
             	  // citem.setQuantity(1);
             	//	System.out.println("new item");
             	   
             	 //}
             	boolean exist = false;
                for (CartItem c : cartList) {
                	System.out.println(c.getItemId() + "-"+id);
                    if (c.getItemId() == id) {
                        exist = true;
                    	c.setQuantity(c.getQuantity()+1);
                    	//citem.setTotal_price(citem.getPrice()*citem.getQuantity());
                        out.println("<h3 style='color:crimson; text-align: center'>Item Already in Cart. <a href='cart.jsp'>GO to Cart Page</a></h3>");
                    }
                }

                if (!exist) {
                	CartItem citem = new CartItem();
                	 citem.setItem_id(id);
                	 citem.setItemId(id);
                	 citem.setQuantity(1);
                	 
                    cartList.add(citem);
                    response.sendRedirect("index.jsp");
                }
                
                
            }
           System.out.println("Addtocartservlet line 87"+cartList); 	
           session.setAttribute("cart-list", cartList);         	 
            }
        
        catch(Exception e){
        	e.printStackTrace();
        }

     }
  
}