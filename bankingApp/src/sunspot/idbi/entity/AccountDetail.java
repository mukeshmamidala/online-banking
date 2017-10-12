package sunspot.idbi.entity;

import javax.persistence.*;

@Entity
@Table(name = "accountDetail")
public class AccountDetail {

	// mobile no is userid
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="transaction_ID") 
	private long transactionId;
	
	@Column(name = "credit",nullable=false)
	private long credit;

		@Column(name = "debit",nullable = false)
	private long debit;

	@Column(name = "transaction_date",nullable = false)
	private String date;

	@Column(name = "userId",nullable = false)
	private long userId;

	
/*	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}*/

	public long getCredit() {
		return credit;
	}

	public void setCredit(long credit) {
		this.credit = credit;
	}

	public long getDebit() {
		return debit;
	}

	public void setDebit(long debit) {
		this.debit = debit;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}


}