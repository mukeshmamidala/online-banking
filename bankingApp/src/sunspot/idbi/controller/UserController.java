package sunspot.idbi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sunspot.idbi.dao.BankOperationDao;
import sunspot.idbi.entity.AccountDetail;
import sunspot.idbi.entity.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/userController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
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
		User user=null;
		String page =request.getParameter("page");

		if(session== null){
			request.setAttribute("errorStatus", "fail");
			dispatcher = request
					.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);	
			return;
		}
		
		if(page!=null && page.equals("userAccount.jsp")){
			
			long userId=(long)session.getAttribute("userId");
			List<AccountDetail> accountSummryList=new BankOperationDao().getAccountSummry(userId);
			request.setAttribute("accountSummryList", accountSummryList);
			dispatcher=request
					.getRequestDispatcher("userAccount.jsp");
			dispatcher.forward(request, response);
		}
		
		if(page!=null && page.equals("userMiniStatement.jsp")){
			long userId=(long)session.getAttribute("userId");
			List<AccountDetail> accountSummryList=new BankOperationDao().getAccountSummry(userId);
			request.setAttribute("balance", new BankOperationDao().getcurrentBalance(userId));
			request.setAttribute("accountSummryList", accountSummryList);
			dispatcher=request
					.getRequestDispatcher("userMiniStatement.jsp");
			dispatcher.forward(request, response);
		}
		if(page!=null && page.equals("moneyTransfer.jsp")){
			long userId=(long)session.getAttribute("userId");
					dispatcher=request
					.getRequestDispatcher("moneyTransfer.jsp");
			dispatcher.forward(request, response);
		}
		if(page!=null && page.equals("transferMoney")){
			long userId=(long)session.getAttribute("userId");
			
			long trnasferToUserId=Long.parseLong(request.getParameter("userId"));
			long amt=Long.parseLong(request.getParameter("amount"));
			
			boolean status1= new BankOperationDao().transfer(trnasferToUserId, userId, amt);
			
			if(status1){
				request.setAttribute("msg", "Money transfer Done...");
				dispatcher=request
						.getRequestDispatcher("success.jsp");
				dispatcher.forward(request, response);
			}else{
				request.setAttribute("msg", "OOPS !!!! Something went wrong...");
				dispatcher=request
						.getRequestDispatcher("success.jsp");
				dispatcher.forward(request, response);
			}
	}
		
		
		if(page!=null && page.equals("billPay.jsp")){
			long userId=(long)session.getAttribute("userId");
	
			dispatcher=request
					.getRequestDispatcher("billPay.jsp");
			dispatcher.forward(request, response);
		}
		
		if(page!=null && page.equals("getBalance")){
			long userId=(long)session.getAttribute("userId");
	
			long bal=new BankOperationDao().getcurrentBalance(userId);
			request.setAttribute("Bal", bal);
			
			dispatcher=request
					.getRequestDispatcher("currentbal.jsp");
			dispatcher.forward(request, response);
		}
		
		//*****************
		if(page!=null && page.equals("getAllUser")){
			long userId=(long)session.getAttribute("userId");
	
			List<User> listUser=new BankOperationDao().getAllUser();
			request.setAttribute("listUser", listUser);
			
			dispatcher=request
					.getRequestDispatcher("allUserList.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
	}

}
