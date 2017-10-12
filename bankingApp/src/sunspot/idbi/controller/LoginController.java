package sunspot.idbi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import sunspot.idbi.dao.LoginDao;
import sunspot.idbi.entity.User;
import sunspot.idbi.exception.UserNotFoundException;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**	
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//action=changePassPage
		
		
		
		
		HttpSession session = request.getSession(false);
		if(session != null)	
			session.invalidate();
		response.sendRedirect("Login.jsp");		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher=null;
		User user=null;
		String userId =request.getParameter("username");
		String pwd = request.getParameter("userpwd");
		try {
			user=new LoginDao().isvalidUser(Long.parseLong(userId),pwd);
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			request.setAttribute("errorStatus", "fail");
			dispatcher = request
					.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);
			e.printStackTrace();
			return;
		}
		
		session.setAttribute("userId", user.getUserId());
		
		if(user.getRole().equals("admin")){
			session.setAttribute("userName", user.getUserName());
			session.setAttribute("userRole", user.getRole());
			
			 dispatcher = request
					.getRequestDispatcher("admin.jsp");
			dispatcher.forward(request, response);
		return;
		}
		if(user.getRole().equals("user")){
			session.setAttribute("userName", user.getUserName());
			session.setAttribute("userRole", user.getRole());			
			session.setAttribute("userId", user.getUserId()); 
			dispatcher = request
					.getRequestDispatcher("user.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		if(user.getRole().equals("cashier")){
			session.setAttribute("userName", user.getUserName());
			session.setAttribute("userRole", user.getRole());			
			 dispatcher = request
					.getRequestDispatcher("cashier.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
	}

}
