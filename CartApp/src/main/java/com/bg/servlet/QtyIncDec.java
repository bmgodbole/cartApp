package com.bg.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bg.model.CartItem;

/**
 * Servlet implementation class QtyIncDec
 */
@WebServlet("/quantity-inc-dec")
public class QtyIncDec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QtyIncDec() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    String action = request.getParameter("action");
	    int id = Integer.parseInt( request.getParameter("id"));
	    ArrayList<CartItem> attribute = (ArrayList<CartItem>) request.getSession().getAttribute("cart-list");
		ArrayList<CartItem> cart_list = attribute;
	    if(action!=null && id >= 1)
	    {
	    	if(action.equals("inc"))
	    	{
	    		for(CartItem c:cart_list)
	    		{
	    			if(c.getItemId()==id)
	    			{
	    				c.setQuantity(c.getQuantity()+1);
	    				c.setTotal_price(c.getPrice()*c.getQuantity());
	    			    break;
	    			}
	    		}
	    		response.sendRedirect("cart.jsp");
	    	}
	        if(action.equals("dec"))
	        {
	        	for(CartItem c:cart_list)
	    		{
	    			if(c.getItemId()==id && c.getQuantity()>1)
	    			{
	    				  c.setQuantity(c.getQuantity()-1);
	    				  c.setTotal_price(c.getPrice()*c.getQuantity());
	    			      break;
	    			}
	    		}
	        	response.sendRedirect("cart.jsp");
	        }
	    }
	    else
	    {
	    	response.sendRedirect("cart.jsp");
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		doGet(request, response);
	}

}
