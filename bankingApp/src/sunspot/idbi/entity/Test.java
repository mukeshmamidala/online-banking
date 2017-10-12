package sunspot.idbi.entity;

import org.hibernate.Session;
import org.hibernate.Transaction;

import sunspot.idbi.dao.LoginDao;
import sunspot.idbi.exception.MobileAlreadyRegistered;
import sunspot.idbi.exception.UserNotFoundException;
import sunspot.idbi.util.DbConnector;



public class Test {

	/**
	 * @param args
	 * @throws MobileAlreadyRegistered 
	 */
	
	// run this code so u get all database table and one admin user 
	public static void main(String[] args) throws MobileAlreadyRegistered {
		DbConnector connector=DbConnector.getInstance();
		Session session=connector.getSession();
		
		User user=new User();
		user.setUserId(8019508912l);
		user.setPassword("123");
		user.setRole("admin");
		user.setUserName("Mounika");
		
		
//		User user1=new User();
//		user1.setUserId(9160588752l);
//		user1.setPassword("123");
//		user1.setRole("cashier");
//		user1.setUserName("manni");
		
		
		
		//new LoginDao().addUser(user);
		//new LoginDao().addUser(user1);
		Transaction transaction=session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
		
//		try {
//			User user=new LoginDao().isvalidUser(8019508912l);
//			System.out.println(user.getUserName());
//		} catch (UserNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}

}
