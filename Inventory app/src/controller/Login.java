package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Users;
import service.UsersDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String empid=request.getParameter("empid");
		String password=request.getParameter("password");
		Users users=new Users();
		users.setEmpid(empid);
		users.setPassword(password);
		boolean flag=new UsersDao().checkLogin(users);
		if(flag)
		{
			HttpSession session=request.getSession();
		    session.setAttribute("empid", empid);
		 response.sendRedirect("UserHome.jsp");
		}
		else
		{
			 response.sendRedirect("Login.html");
		}
		
		
	}

}
