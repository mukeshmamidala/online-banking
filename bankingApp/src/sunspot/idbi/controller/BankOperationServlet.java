package sunspot.idbi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sunspot.idbi.dao.BankOperationDao;

/**
 * Servlet implementation class BankOperationServlet
 */
@WebServlet("/bankOperationServlet")
public class BankOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankOperationServlet() {
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
		String operation=request.getParameter("operation");
		
		if(session==null){
			request.setAttribute("errorStatus", "fail");
			dispatcher = request
					.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		if(operation.equals("deposit")){
			//operation=deposit
			long userId=Long.parseLong(request.getParameter("userId"));
			long amt=Long.parseLong(request.getParameter("amount"));
			
			boolean status=new BankOperationDao().depositAmount(userId, amt);
			if(status){
				request.setAttribute("msg", " Amount deposited successfuly !!");
				dispatcher = request
						.getRequestDispatcher("success.jsp");
				dispatcher.forward(request, response);
			}else{
				request.setAttribute("status", " OOPS!! something went wrong try again.");
				dispatcher = request
						.getRequestDispatcher("deposit.jsp");
				dispatcher.forward(request, response);
	
			}
		}
		
		
	}

}
