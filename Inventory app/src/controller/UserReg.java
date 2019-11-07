package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Users;
import service.UsersDao;

/**
 * Servlet implementation class UserReg
 */
@WebServlet("/UserReg")
public class UserReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String ename = request.getParameter("ename");
		String empid = request.getParameter("empid");
		String password = request.getParameter("password");
		String contactno = request.getParameter("contactno");
		String gender = request.getParameter("gender");
		String mailid = request.getParameter("mailid");
		
		Users users = new Users(ename, empid, password, gender, contactno, mailid);
		
		boolean flag = new UsersDao().registerUser(users);
		if (flag){
			response.sendRedirect("Login.html");
		}
		
		else {
			response.sendRedirect("UserReg.html");
		}
	}

}
