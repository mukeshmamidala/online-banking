package sunspot.idbi.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sunspot.idbi.entity.User;
import sunspot.idbi.exception.MobileAlreadyRegistered;
import sunspot.idbi.exception.UserNotFoundException;
import sunspot.idbi.util.DbConnector;

public class LoginDao {

	Session session;
	DbConnector connector;

	public LoginDao() {
		connector = DbConnector.getInstance();
		session = connector.getSession();
	}

	/**
	 * @param userID
	 * @return User
	 * @throws UserNotFoundException
	 * 
	 * 
	 */
	public User isvalidUser(long userID, String pwd)
			throws UserNotFoundException {

		if (!session.isConnected())
			session = connector.getSession();
		
			User user = (User) session.get(User.class, userID);
			if (user == null) {
				throw new UserNotFoundException();
			}
			if (user.getPassword().equals(pwd)) {
				session.close();
				return user;
			} else {
				session.close();
				throw new UserNotFoundException();
			}
		
	}

	/**
	 * @param user
	 * @return boolean use add user
	 * @throws MobileAlreadyRegistered
	 */
	public synchronized boolean addUser(User user) throws MobileAlreadyRegistered {

		Transaction transaction = session.beginTransaction();
		User fetchedUser = null;

		fetchedUser = (User) session.get(User.class, user.getUserId());
		
			if (fetchedUser != null) {
				session.close();
				throw new MobileAlreadyRegistered();
			} else {
				if(!session.isConnected())
					session=connector.getSession();
				session.save(user);
				transaction.commit();
				session.close();
				return true;
			}
		
	}
	
	
	public boolean isValidAccount(long userId) {

		if (!session.isConnected())
			session = connector.getSession();

		User user = (User) session.get(User.class, userId);
		if (user == null) {
			session.close();
			return false;
		} else {
			session.close();
			return true;
		}
	}
	public boolean chnangePasswrod(long userId,String chngPwd){
		
		boolean status=isValidAccount(userId);
		if(status){
			if(!session.isConnected()){
				session=connector.getSession();
			}
			Transaction transaction = session.beginTransaction();
			User user=session.get(User.class, userId);
			if(user!=null){
				user.setPassword(chngPwd);
			}
			transaction.commit();
			return true;
		}
		return false;
	
	}	
	
	
	
	

}