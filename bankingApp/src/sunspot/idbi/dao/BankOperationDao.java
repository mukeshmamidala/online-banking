package sunspot.idbi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import sunspot.idbi.entity.AccountDetail;
import sunspot.idbi.entity.CurrentBalance;
import sunspot.idbi.entity.User;
import sunspot.idbi.util.DateConverter;
import sunspot.idbi.util.DbConnector;

public class BankOperationDao {

	Session session;
	DbConnector connector;

	public BankOperationDao() {
		connector = DbConnector.getInstance();
		session = connector.getSession();
	}

	public boolean depositAmount(long userId, long amt) {
		boolean status = isValidAccount(userId);
		if (status) {

			if (!session.isConnected())
				session = connector.getSession();

			Transaction transaction = session.beginTransaction();

			AccountDetail accountDetail = new AccountDetail();
			accountDetail.setCredit(amt);
			accountDetail.setDebit(0);
			accountDetail.setUserId(userId);
			accountDetail.setDate(DateConverter.getDate());
			// accountDetail.setTransactionId(0);

			CurrentBalance currentBalance = session.get(CurrentBalance.class,
					userId);

			if (currentBalance == null) {
				CurrentBalance cb = new CurrentBalance();
				cb.setBalance(amt);
				cb.setUserId(userId);
				session.save(cb);
			} else {
				currentBalance.setBalance(currentBalance.getBalance() + amt);
				session.save(currentBalance);
			}

			if (!session.isConnected())
				session = connector.getSession();

			session.save(accountDetail);
			transaction.commit();
			session.close();
			return true;
		} else {
			return false;
		}

	}

	
public boolean transfer(long transferToUserId,long transferfromUserId,long amt){
	boolean status = isValidAccount(transferToUserId);
	
	if(status){
		if (!session.isConnected())
			session = connector.getSession();
		
		long currentBalOFfromUser=getcurrentBalance(transferfromUserId) ;
		
		if(currentBalOFfromUser >=amt){
			if (!session.isConnected())
				session = connector.getSession();
			Transaction transaction = session.beginTransaction();
			
			if (!session.isConnected())
				session = connector.getSession();
			//From
			AccountDetail ac=new AccountDetail();
			ac.setCredit(0);
			ac.setDebit(amt);
			ac.setDate(DateConverter.getDate());
			ac.setUserId(transferfromUserId);

			session.save(ac);
			
			
			if(!session.isConnected())
				session=connector.getSession();
					
			CurrentBalance balance=session.get(CurrentBalance.class, transferfromUserId);
			balance.setBalance(currentBalOFfromUser-amt);
			
			transaction.commit();
			//To
			
			depositAmount(transferToUserId,  amt); 	
			return true;
			
		}
	
	}
	return false;
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

	public List<AccountDetail> getAccountSummry(long userId) {

		boolean status = isValidAccount(userId);
		if (status) {
			if(!session.isConnected())
				session=connector.getSession();
			Query accounDetail = session
					.createQuery("from AccountDetail ad where ad.userId= :userId");
			accounDetail.setParameter("userId", userId);

			@SuppressWarnings("unchecked")
			List<AccountDetail> accountInfoList = accounDetail.list();
			session.close();
			return accountInfoList;
		}else{
			session.close();
			return null;
		}
			
	}

	
	
	
	public List<User> getAllUser() {

			if(!session.isConnected())
				session=connector.getSession();
			
			Query allUser = session
					.createQuery("from User user");
			
			@SuppressWarnings("unchecked")
			List<User> accountInfoList = allUser.list();
			session.close();
			return accountInfoList;			
	}
	
	
	
	
	
	
	
	
	public long getcurrentBalance(long userId) {

			if(!session.isConnected())
				session=connector.getSession();
					
			CurrentBalance balance=session.get(CurrentBalance.class, userId);
			if (balance==null) {
				session.close();
				return 0;
			}
			session.close();
			return balance.getBalance();
		
	}
	
}
