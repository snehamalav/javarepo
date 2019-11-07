package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import service.EmpDao;




	public class empreg1 extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public empreg1() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			int eid = Integer.parseInt(request.getParameter("eid"));
			System.out.println();
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String password = request.getParameter("password");
			int contactno= Integer.parseInt(request.getParameter("contactno"));
			String gender = request.getParameter("gender");
			String email = request.getParameter("email");
			String dname = request.getParameter("dname");
			Employee emp = new Employee(eid, fname, lname, password, contactno, gender, email, dname);
			
			boolean flag = new EmpDao().registerUser(emp);
			if (flag){
				response.sendRedirect("home.jsp");
			}
			
			else {
				response.sendRedirect("empreg.html");
			}
		}

	}


