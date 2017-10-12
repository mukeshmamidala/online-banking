package sunspot.idbi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sunspot.idbi.dao.LoginDao;
import sunspot.idbi.entity.User;
import sunspot.idbi.exception.MobileAlreadyRegistered;

/**
 * Servlet implementation class RegisterUserController
 */
@WebServlet("/registerUser")
public class RegisterUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		RequestDispatcher dispatcher=null;
		if(session== null){
			request.setAttribute("errorStatus", "fail");
			dispatcher = request
					.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);	
			return;
		}else{
			User user=new User();
			user.setUserName(request.getParameter("username"));
			//default password
			user.setPassword("123");
			user.setRole(request.getParameter("role").toLowerCase());
			user.setUserId(Long.parseLong(request.getParameter("mobile")));
			
			
				try {
					boolean status=new LoginDao().addUser(user);
					if(status){
						request.setAttribute("msg", "User Added successfuly !!!");
						dispatcher=request
						.getRequestDispatcher("success.jsp");
						dispatcher.forward(request, response);
					}
				} catch (MobileAlreadyRegistered e) {
					request.setAttribute("status", "Mobile is already registered enter other number");
					dispatcher=request
					.getRequestDispatcher("createUser.jsp");
					dispatcher.forward(request, response);
					e.printStackTrace();
				}	
			
			
		}
		
	}

}
