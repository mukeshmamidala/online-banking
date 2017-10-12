package sunspot.idbi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sunspot.idbi.dao.LoginDao;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.sendRedirect("changePassword.jsp");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId =request.getParameter("username");
		String pwd = request.getParameter("userpwd");
		
		boolean status=new LoginDao().chnangePasswrod(Long.parseLong(userId), pwd);
		if(status){
			response.sendRedirect("Login.jsp");
		}else{
			RequestDispatcher dispatcher;
			request.setAttribute("errorStatus", "fail");
			dispatcher = request
					.getRequestDispatcher("changePassword.jsp");
			dispatcher.forward(request, response);
		
		}
		
	}

}
