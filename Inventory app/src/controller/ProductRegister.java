package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import model.Users;
import service.ProductsDao;
import service.UsersDao;

/**
 * Servlet implementation class ProductRegister
 */
@WebServlet("/ProductRegister")
public class ProductRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pid=request.getParameter("pid");
		String pname=request.getParameter("pname");
		int unitprice=Integer.parseInt(request.getParameter("unitprice"));
		int stock=Integer.parseInt(request.getParameter("stock"));
		String category=request.getParameter("category");
        Product product = new Product(pid, pname, unitprice, stock, category);
		
		boolean flag = new ProductsDao().productRegister(product);
		if (flag){
		   RequestDispatcher rd=request.getRequestDispatcher("UserHome.jsp");
		   request.setAttribute("msg", "product is successfully added");
			System.out.println("successfully registered");
			rd.forward(request,response);
		}
		
		else {
			 RequestDispatcher rd=request.getRequestDispatcher("UserHome.jsp");
			   request.setAttribute("msg", "product is  not added");
			System.out.println(" failed");
			rd.forward(request,response);
		}
	}

}
